package strategy;

import java.util.List;
import model.ParkingSlot;

//abstraction using interface (complete/ 100% abstraction achieved)
public interface ParkingStrategy {
    ParkingSlot findSlot(List<ParkingSlot> slots);
}