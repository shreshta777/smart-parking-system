import java.util.*;

import factory.VehicleFactory;
import model.*;
import service.*;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingStrategy strategy = new NearestSlotStrategy();
        ParkingLot lot = ParkingLot.getInstance(5, strategy);

        Map<Integer, Ticket> tickets = new HashMap<>();

        while (true) {
            System.out.println("\n===== SMART PARKING SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Available Slots");
            System.out.println("4. Exit Program");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter vehicle type (car/bike/truck): ");
                        System.out.println("1. Car  2. Bike  3. Truck");
                        int typeChoice = sc.nextInt();
                        sc.nextLine();

                        String type = "";

                        switch (typeChoice) {
                            case 1:
                                type = "car";
                                break;
                            case 2:
                                type = "bike";
                                break;
                            case 3:
                                type = "truck";
                                break;
                            default:
                                System.out.println("Invalid type!");
                                continue;
                        }

                        System.out.print("Enter vehicle number: ");
                        String number = sc.nextLine();

                        Vehicle v = VehicleFactory.createVehicle(type, number);
                        Ticket t = lot.parkVehicle(v);

                        if (t != null) {
                            tickets.put(t.hashCode(), t);
                            System.out.println("Ticket ID: " + t.hashCode());
                        }
                        break;

                    case 2:
                        System.out.print("Enter Ticket ID: ");
                        int id = sc.nextInt();

                        Ticket ticket = tickets.get(id);

                        if (ticket == null) {
                            System.out.println("Invalid Ticket!");
                        } else {
                            lot.exitVehicle(ticket);
                            tickets.remove(id);
                        }
                        break;

                    case 3:
                        lot.showAvailableSlots(); // we’ll add this method next
                        break;

                    case 4:
                        System.out.println("Exiting system...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
