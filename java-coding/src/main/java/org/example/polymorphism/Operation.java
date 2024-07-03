package org.example.polymorphism;

class Operation {
    void add(int a, int b) {
        System.out.println("Sum is " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("Sum is " + (a + b));
    }
}