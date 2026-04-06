package model;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;

    public Ticket(int id, Vehicle vehicle, ParkingSlot slot) {
        this.id = id;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }
    
    public int getId() {
    return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}