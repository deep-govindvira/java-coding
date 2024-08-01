package org.example.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Retrieve a value
        System.out.println("Value for key 'Apple': " + map.get("Apple"));

        // Remove a key-value pair
        map.remove("Banana");

        // Check if a key exists
        if (map.containsKey("Cherry")) {
            System.out.println("Cherry exists in the map.");
        }

        // Get the size of the map
        System.out.println("Size of the map: " + map.size());

        // Iterate through the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

