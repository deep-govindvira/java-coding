package org.example.dp.composite;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Shape {
    void draw();
}

// Leaf class
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// Composite class
class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(circle1);
        compositeShape.addShape(circle2);
        compositeShape.draw();
    }
}