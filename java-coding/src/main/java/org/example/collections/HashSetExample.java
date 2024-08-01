package org.example.collections;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate element

        // Displaying the HashSet
        System.out.print("HashSet:");
        for (String element : hashSet) System.out.print(element + " ");
        System.out.println();


        // Checking if an element is present
        boolean hasBanana = hashSet.contains("Banana");
        System.out.println("HashSet contains Banana: " + hasBanana);

        // Removing an element
        hashSet.remove("Cherry");
        System.out.println("HashSet after removing Cherry: " + hashSet);

        // Iterating over the elements
        System.out.println("Iterating over HashSet:");
        for (String element : hashSet) {
            System.out.println(element);
        }
    }
}
