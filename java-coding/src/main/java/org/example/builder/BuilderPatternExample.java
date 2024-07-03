package org.example.builder;

// Fruit class
class Fruit {
    private String name;

    private Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit {\n" +
            "\tname = '" + name + '\'' +
            "\n}";
    }

    // Builder class
    static class Builder {
        private String name;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Fruit build() {
            return new Fruit(name);
        }
    }
}

// Usage example
public class BuilderPatternExample {
    public static void main(String[] args) {
        Fruit product = new Fruit.Builder()
            .setName("Orange")
            .build();
        System.out.println(product);
    }
}
