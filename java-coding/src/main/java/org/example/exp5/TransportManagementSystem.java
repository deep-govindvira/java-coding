package org.example.exp5;

// Interface for Engine
interface Engine {
    void start();
    void stop();
}

// Abstract class for Vehicle
abstract class Vehicle {
    protected String name;
    protected int speed;
    protected Engine engine; // Object composition

    public Vehicle(String name, int speed, Engine engine) {
        this.name = name;
        this.speed = speed;
        this.engine = engine;
    }

    abstract void move();
    abstract void stop();

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

// Concrete class for Car
class Car extends Vehicle {

    public Car(String name, int speed, Engine engine) {
        super(name, speed, engine);
    }

    @Override
    void move() {
        System.out.println(name + " car is moving at speed " + speed);
        engine.start();
    }

    @Override
    void stop() {
        System.out.println(name + " car has stopped.");
        engine.stop();
    }
}

// Concrete class for Bus
class Bus extends Vehicle {

    public Bus(String name, int speed, Engine engine) {
        super(name, speed, engine);
    }

    @Override
    void move() {
        System.out.println(name + " bus is moving at speed " + speed);
        engine.start();
    }

    @Override
    void stop() {
        System.out.println(name + " bus has stopped.");
        engine.stop();
    }
}

// Concrete class for Motorcycle
class Motorcycle extends Vehicle {

    public Motorcycle(String name, int speed, Engine engine) {
        super(name, speed, engine);
    }

    @Override
    void move() {
        System.out.println(name + " motorcycle is moving at speed " + speed);
        engine.start();
    }

    @Override
    void stop() {
        System.out.println(name + " motorcycle has stopped.");
        engine.stop();
    }
}

// Concrete class for Petrol Engine
class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Petrol engine stopped.");
    }
}

// Concrete class for Electric Engine
class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stopped.");
    }
}

// Main class for testing
public class TransportManagementSystem {
    public static void main(String[] args) {
        // Creating engines
        Engine petrolEngine = new PetrolEngine();
        Engine electricEngine = new ElectricEngine();

        // Creating vehicles with engine composition
        Vehicle car = new Car("Tesla", 120, electricEngine);
        Vehicle bus = new Bus("CityBus", 60, petrolEngine);
        // Vehicle motorcycle = new Motorcycle("Yamaha", 90, petrolEngine);

        // Testing the vehicles
        car.move();
        car.stop();

        // Demonstrating engine change
        System.out.println("\nChanging the engine of the car to petrol engine.");
        car.setEngine(petrolEngine);  // Changing the engine
        car.move();
        car.stop();

        bus.move();
        bus.stop();

        // motorcycle.move();
        // motorcycle.stop();
    }
}

