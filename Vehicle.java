package model;

//abstraction
public abstract class Vehicle {
    protected String number;  //encapsulation- using protected

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    //Polymorphism
    public abstract double calculateFee(long hours);
}