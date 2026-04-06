package factory;
import model.*;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String number) {

        switch (type.toLowerCase()) {
            case "car":
                return new Car(number);
            case "bike":
                return new Bike(number);
            case "truck":
                return new Truck(number);
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}