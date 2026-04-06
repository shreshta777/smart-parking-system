package model;

public class ParkingSlot {
    private int slotNumber;   //encapsulation using protected
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    //setter method
    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.isOccupied = true;
    }

    //setter method
    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    //getter method
    public int getSlotNumber() {
        return slotNumber;
    }

    //getter method
    public Vehicle getVehicle() {
        return vehicle;
    }
}