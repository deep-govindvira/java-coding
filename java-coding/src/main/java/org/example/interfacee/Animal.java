package org.example.interfacee;

// Defining an interface
public interface Animal {
    // Abstract method (no body)
    void makeSound();

    // Default method (has a body)
    default void eat() {
        System.out.println("Eating...");
    }
}
