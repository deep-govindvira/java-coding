package org.example.privateClass;

public class Outer {

    private class Inner {
        void display() {
            System.out.println("Inner Class Method");
        }
    }

    void createInnerClassInstance() {
        Inner inner = new Inner();
        inner.display();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.createInnerClassInstance();
        // Cannot access InnerClass directly from here
        // OuterClass.InnerClass inner = outer.new InnerClass(); // This would cause a compile-time error
    }
}
