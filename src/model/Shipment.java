package model;

public class Shipment implements Trackable {

    private int id;
    private String trackingCode;
    private CustomerInfo sender;
    private CustomerInfo receiver;
    private double weight;
    private ShipmentStatus status;

    public Shipment() {
    }

    public Shipment(int id,
                    String trackingCode,
                    CustomerInfo sender,
                    CustomerInfo receiver,
                    double weight,
                    ShipmentStatus status) {

        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        this.id = id;
        this.trackingCode = trackingCode;
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.status = status;
    }

    @Override
    public String getTrackingCode() {
        return trackingCode;
    }

    public void updateStatus(ShipmentStatus newStatus) {
        this.status = newStatus;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackingCodeValue() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public CustomerInfo getSender() {
        return sender;
    }

    public void setSender(CustomerInfo sender) {
        this.sender = sender;
    }

    public CustomerInfo getReceiver() {
        return receiver;
    }

    public void setReceiver(CustomerInfo receiver) {
        this.receiver = receiver;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.weight = weight;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }
}
