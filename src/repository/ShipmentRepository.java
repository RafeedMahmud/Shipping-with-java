package repository;

import model.Shipment;
import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {

    private List<Shipment> shipments = new ArrayList<>();

    public void save(Shipment shipment) {
        shipments.add(shipment);
        System.out.println("Shipment saved in memory (temporary)");
    }

    public List<Shipment> findAll() {
        return shipments;
    }

    public long countAll() {
        return shipments.size();
    }

    public long countDelivered() {
        return shipments.stream()
                .filter(s -> s.getStatus() != null && s.getStatus().name().equals("DELIVERED"))
                .count();
    }
}
