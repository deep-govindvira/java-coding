package org.example.polymorphism;

public class Main {
    public static void main(String[] args) {

        // Compile-time Polymorphism (Static Binding or Method Overloading):
        Operation operation = new Operation();
        operation.add(5, 10); // Calls the first add method
        operation.add(5.5, 10.5); // Calls the second add method

        Animal animal;

        animal = new Dog();
        animal.sound(); // Outputs: Dog barks

        animal = new Cat();
        animal.sound(); // Outputs: Cat meows
    }
}

