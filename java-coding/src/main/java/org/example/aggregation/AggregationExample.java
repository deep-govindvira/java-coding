package org.example.aggregation;


class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private final Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        if (engine != null) {
            engine.start();
            System.out.println("Car started.");
        }
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        // Car has an Engine, but the Engine can exist independently of the Car'
        Car car = new Car(new Engine());
        car.startCar();
    }
}
