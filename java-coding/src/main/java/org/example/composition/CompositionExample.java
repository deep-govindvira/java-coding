package org.example.composition;

class Heart {
    void beat() {
        System.out.println("Heart is beating.");
    }
}

class Human {
    private final Heart heart;

    Human() {
        this.heart = new Heart();
    }

    void live() {
        heart.beat();
        System.out.println("Human is living.");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        // Human is composed of a Heart, and the Heart cannot exist independently of the Human
        Human human = new Human();
        human.live();
    }
}
