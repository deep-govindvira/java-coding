package org.example.interfacee;

public class Implementation {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();  // Output: Bark
        dog.eat();        // Output: Eating...

        cat.makeSound();  // Output: Meow
        cat.eat();        // Output: Eating...
    }
}

// A class that implements the Animal interface
class Dog implements Animal {
    // Providing implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    // The eat() method can be used as it is from the interface or overridden if needed
}

// Another class that implements the Animal interface
class Cat implements Animal {
    // Providing implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
