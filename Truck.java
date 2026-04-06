package model;

public class Truck extends Vehicle {

    public Truck(String number) {
        super(number);  //use super in constructor to inherit method/variables from vehicle(parent) class
    }

    //runtime polymorphism
    @Override
    public double calculateFee(long hours) {
        return hours * 40;
    }
}