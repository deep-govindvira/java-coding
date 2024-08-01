package org.example.collections;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(3);

        System.out.println("TreeSet: " + numbers);  // Output: TreeSet: [1, 3, 5, 10]

        System.out.println("Contains 5? " + numbers.contains(5));  // Output: Contains 5? true

        numbers.remove(5);

        System.out.println("After removing 5: " + numbers);  // Output: After removing 5: [1, 3, 10]

        System.out.println("First: " + numbers.first());  // Output: First: 1
        System.out.println("Last: " + numbers.last());    // Output: Last: 10
    }
}
