package ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JButton newShipmentButton;

    public MainWindow() {
        setTitle("Parcel Management System");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        layoutComponents();
        registerListeners();
    }

    private void initComponents() {
        newShipmentButton = new JButton("New Shipment");
    }

    private void layoutComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Al-Rahhala Parcel Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel centerPanel = new JPanel();
        centerPanel.add(newShipmentButton);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);
    }

    private void registerListeners() {
        newShipmentButton.addActionListener(e -> {
            NewShipmentForm form = new NewShipmentForm();
            form.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}
