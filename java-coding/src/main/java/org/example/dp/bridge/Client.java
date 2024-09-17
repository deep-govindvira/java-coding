package org.example.dp.bridge;

abstract class Shape {
    private Color color = null;

    Shape(Color color) {
        this.color = color;
    }

    public void draw() {
        color.applyColor();
    }
}

// Refined Abstraction class
class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Circle");
    }
}

// Implementor interface
abstract class Color {
    abstract void applyColor();
}

// Concrete Implementor classes
class RedColor extends Color {
    @Override
    public void applyColor() {
        System.out.println("Red");
    }
}

class BlueColor extends Color {
    @Override
    public void applyColor() {
        System.out.println("Blue");
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(new RedColor());
        circle.draw();
    }
}