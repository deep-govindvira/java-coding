package org.example.polymorphism;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
    void run() {}
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class RunTime {
    public static void main(String[] args) {
        Animal animal;

        animal = new Dog();
        animal.sound(); // Outputs: Dog barks
        // animal cant run though dog can run

        animal = new Cat();
        animal.sound(); // Outputs: Cat meows
    }
}

