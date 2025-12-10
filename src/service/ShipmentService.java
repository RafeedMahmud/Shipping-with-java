package service;

import model.Shipment;
import repository.ShipmentRepository;

import java.util.List;

public class ShipmentService {

    private ShipmentRepository repository = new ShipmentRepository();

    public void addShipment(Shipment shipment) {
        repository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return repository.findAll();
    }

    public long getTotalShipments() {
        return repository.countAll();
    }

    public long getDeliveredCount() {
        return repository.countDelivered();
    }
}
