package org.example.design_pattern.factory;

// Step 1: Create the product interface
interface Shape {
    void draw();
}

// Step 2: Concrete products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Step 3: Factory class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        else if (shapeType.equalsIgnoreCase("SQUARE")) return new Square();
        return null;
    }
}

// Step 4: Use the factory
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();  // Output: Drawing a Circle

        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();  // Output: Drawing a Square
    }
}
