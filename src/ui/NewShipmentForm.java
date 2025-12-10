package ui;

import model.CustomerInfo;
import model.Shipment;
import model.ShipmentStatus;

import javax.swing.*;
import java.awt.*;

public class NewShipmentForm extends JFrame {

    private JTextField senderNameField;
    private JTextField senderPhoneField;
    private JTextField senderAddressField;

    private JTextField receiverNameField;
    private JTextField receiverPhoneField;
    private JTextField receiverAddressField;

    private JTextField weightField;
    private JComboBox<ShipmentStatus> statusComboBox;

    private JButton saveButton;
    private JButton cancelButton;

    public NewShipmentForm() {
        setTitle("New Shipment");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
        layoutComponents();
        registerListeners();
    }

    private void initComponents() {
        senderNameField = new JTextField(20);
        senderPhoneField = new JTextField(20);
        senderAddressField = new JTextField(20);

        receiverNameField = new JTextField(20);
        receiverPhoneField = new JTextField(20);
        receiverAddressField = new JTextField(20);

        weightField = new JTextField(10);

        statusComboBox = new JComboBox<>(ShipmentStatus.values());

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Sender section
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Sender Information"), gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(senderNameField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(senderPhoneField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(senderAddressField, gbc);

        // Receiver section
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Receiver Information"), gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(receiverNameField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(receiverPhoneField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(receiverAddressField, gbc);

        // Shipment info
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Weight (kg):"), gbc);
        gbc.gridx = 1;
        mainPanel.add(weightField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(statusComboBox, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void registerListeners() {
        saveButton.addActionListener(e -> saveShipment());
        cancelButton.addActionListener(e -> dispose());
    }

    private void saveShipment() {
        try {
            String senderName = senderNameField.getText().trim();
            String senderPhone = senderPhoneField.getText().trim();
            String senderAddress = senderAddressField.getText().trim();

            String receiverName = receiverNameField.getText().trim();
            String receiverPhone = receiverPhoneField.getText().trim();
            String receiverAddress = receiverAddressField.getText().trim();

            String weightText = weightField.getText().trim();

            if (senderName.isEmpty() || receiverName.isEmpty() || weightText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill at least sender name, receiver name, and weight.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double weight = Double.parseDouble(weightText);

            CustomerInfo sender = new CustomerInfo(senderName, senderPhone, senderAddress);
            CustomerInfo receiver = new CustomerInfo(receiverName, receiverPhone, receiverAddress);

            ShipmentStatus status = (ShipmentStatus) statusComboBox.getSelectedItem();

            // For now, we just create a Shipment object and print it to console.
            Shipment shipment = new Shipment(
                    0,                        // id (temporary)
                    "TEMP-CODE",              // tracking code (temporary)
                    sender,
                    receiver,
                    weight,
                    status
            );

            System.out.println("New shipment created:");
            System.out.println("Sender: " + sender.getFullName());
            System.out.println("Receiver: " + receiver.getFullName());
            System.out.println("Weight: " + shipment.getWeight());
            System.out.println("Status: " + shipment.getStatus());

            JOptionPane.showMessageDialog(this,
                    "Shipment data captured (no DB yet).",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Weight must be a valid number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Comes from Shipment weight validation
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
