package org.example.interfacee;

/*

Interfaces
    - no need to write public, abstract for methods
    - no need to write public, static, final for variables
    - need to write default for default methods

*/


// Defining an interface
interface Animal {
    int x = 5;
    // Abstract method (no body)
    void makeSound();

    // Default method (has a body)
    default void eat() {
        System.out.println("Eating...");
    }
}
