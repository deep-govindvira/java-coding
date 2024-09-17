package org.example.dp.adapter;

// Target interface
interface Shape {
    void draw();
}

// Adaptee class
class OldRectangle {
    void oldDraw() {
        // ...
    }
}

// Adapter class
class RectangleAdapter implements Shape {
    private OldRectangle oldRectangle;

    public RectangleAdapter(OldRectangle oldRectangle) {
        this.oldRectangle = oldRectangle;
    }

    @Override
    public void draw() {
        oldRectangle.oldDraw();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Shape shape = new RectangleAdapter(new OldRectangle());
        shape.draw();
    }
}