package service;

import java.util.*;
import model.*;
import strategy.*;
import exception.*;

public class ParkingLot {

    private static ParkingLot instance; // Singleton

    private List<ParkingSlot> slots;   //encapsulation using private keyword
    private ParkingStrategy strategy;
    private int ticketCounter = 1;
    private Map<Integer, Ticket> activeTickets = new HashMap<>();

    private ParkingLot(int size, ParkingStrategy strategy) {
        this.strategy = strategy;
        slots = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    //getter method
    public static ParkingLot getInstance(int size, ParkingStrategy strategy) {
        if (instance == null) {
            instance = new ParkingLot(size, strategy);
        }
        return instance;
    }

    public void showAvailableSlots() {
    System.out.println("Available Slots:");

    for (ParkingSlot slot : slots) {
        if (!slot.isOccupied()) {
            System.out.print(slot.getSlotNumber() + " ");
        }
    }
    System.out.println();
}

    public Ticket parkVehicle(Vehicle v) {
        ParkingSlot slot = strategy.findSlot(slots);

        if (slot == null) {
            throw new ParkingFullException("Parking is full!");
        }

        slot.parkVehicle(v);
        Ticket ticket = new Ticket(ticketCounter, v, slot);
        activeTickets.put(ticketCounter, ticket);

        System.out.println("Vehicle parked at slot: " + slot.getSlotNumber());

        ticketCounter++;
        return ticket;
    }

    public void exitVehicle(Ticket ticket) {

        ParkingSlot slot = ticket.getSlot();
        slot.removeVehicle();

        long hours = Math.max(1,
                java.time.Duration.between(
                        ticket.getEntryTime(),
                        java.time.LocalDateTime.now()
                ).toHours()
        );

        //Polymorphism used here
        double fee = ticket.getVehicle().calculateFee(hours);

        System.out.println("Vehicle exited. Fee: " + fee);
    }
}