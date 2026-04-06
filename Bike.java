package model;

public class Bike extends Vehicle {

    public Bike(String number) {
        super(number);   //use super in constructor to inherit method/variables from vehicle(parent) class
    }

    //runtime polymorphism
    @Override
    public double calculateFee(long hours) {
        return hours * 10;
    }
}