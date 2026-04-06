package strategy;

import java.util.List;
import model.ParkingSlot;

public class NearestSlotStrategy implements ParkingStrategy {

    //runtime polymorphism
    @Override
    public ParkingSlot findSlot(List<ParkingSlot> slots) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }
}