## Smart Parking System (Java OOP Project)

---

## Overview
The Smart Parking System is a console-based Java application that simulates a real-world parking lot.  
It allows users to park vehicles, generate tickets, calculate parking fees, and manage parking slots dynamically.

This project demonstrates strong Object-Oriented Programming (OOP) concepts along with design patterns and clean architecture.

---

## Features
-  Park vehicles (Car, Bike, Truck)
-  Generate ticket with unique ID
-  Automatic fee calculation based on vehicle type and duration
-  View available parking slots
-  Exit vehicle using ticket ID
-  Exception handling for invalid inputs and full parking

---

## OOP Concepts Used

### Encapsulation
- Data members are kept private (e.g., in ParkingSlot, Ticket)
- Access is provided through public getter methods

###  Abstraction
- Abstract class: `Vehicle`
- Interface: `ParkingStrategy`
- Hides implementation details and exposes only required functionality

###  Inheritance
- `Car`, `Bike`, and `Truck` inherit from `Vehicle`
- Promotes code reuse and hierarchy

###  Polymorphism
- Method overriding: `calculateFee()` implemented differently in each vehicle class
- Runtime polymorphism used while calculating parking fee

---

##  Design Patterns Used

###  Factory Pattern
- Implemented in `VehicleFactory`
- Creates objects based on user input without exposing instantiation logic

###  Strategy Pattern
- Implemented using `ParkingStrategy`
- Allows flexible parking slot allocation logic

###  Singleton Pattern
- Implemented in `ParkingLot`
- Ensures only one instance of parking lot exists

##  Exception Handling

The system includes robust exception handling to ensure smooth operation and prevent crashes.

###  Custom Exception
- `ParkingFullException` is created to handle cases when parking slots are full

###  Built-in Exceptions
- `IllegalArgumentException` is used for invalid vehicle types

###  Runtime Handling
- `try-catch` blocks in `Main` ensure the program continues even if an error occurs

###  Input Validation
- Invalid ticket IDs and wrong inputs are handled gracefully with user-friendly messages
