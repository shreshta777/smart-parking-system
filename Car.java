package model;

//inheritance
public class Car extends Vehicle {

    public Car(String number) {
        super(number);  //use super in constructor to inherit method/variables from vehicle(parent) class
    }

    //runtime polymorphism
    @Override
    public double calculateFee(long hours) {
        return hours * 20;
    }
}