package org.example.polymorphism;

class Operation {
    void add(int a, int b) {
        System.out.println("Sum is " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("Sum is " + (a + b));
    }
}

public class CompileTime {
    public static void main(String[] args) {
        Operation operation = new Operation();
        operation.add(5, 10); // Calls the first add method
        operation.add(5.5, 10.5); // Calls the second add method
    }
}