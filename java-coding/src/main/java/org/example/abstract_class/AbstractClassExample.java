package org.example.abstract_class;


// Abstract class
abstract class Vehicle {
    // Abstract method (does not have a body)
    abstract void start();

    // Concrete method (has a body)
    void stop() {
        System.out.println("Vehicle is stopping...");
    }
}

// Subclass (inheriting from Vehicle)
class Car extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void start() {
        System.out.println("Car is starting with a key...");
    }
}

// Subclass (inheriting from Vehicle)
class Bike extends Vehicle {
    // Providing implementation for the abstract method
    @Override
    void start() {
        System.out.println("Bike is starting with a self-start...");
    }
}

// Main class
public class AbstractClassExample {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();

        Vehicle myBike = new Bike();
        myBike.start();
        myBike.stop();
    }
}

