package org.example.design_pattern.prototype;

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete Prototype
class ConcretePrototype implements Prototype {
    private String data;

    public ConcretePrototype(String data) {
        this.data = data;
    }

    @Override
    public Prototype clone() {
//        return new ConcretePrototype(this.data); // shallow copy
        return new ConcretePrototype(new String(this.data)); // deep copy
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" + "data='" + data + '\'' + '}';
    }

    public String getData() {
        return data;
    }
}

// Client
public class PrototypeDemo {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Hello");
        ConcretePrototype copy = (ConcretePrototype) original.clone();

        System.out.println(original); // ConcretePrototype{data='Hello'}
        System.out.println(copy);     // ConcretePrototype{data='Hello'}
        System.out.println(original == copy); // false
        System.out.println(original.getData() == copy.getData()); // true because of shallow copy

    }
}