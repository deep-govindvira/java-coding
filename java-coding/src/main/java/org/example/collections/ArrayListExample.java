package org.example.collections;

import h._xdot_op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Blueberry");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("First element: " + list.get(0));
        System.out.println("Second element: " + list.get(1));

        list.remove("Banana");
        list.remove(1);

        for (String fruit : list) System.out.println(fruit);

        System.out.println("Contains 'Apple': " + list.contains("Apple"));
        System.out.println("List size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());
        list.clear();
        System.out.println("List cleared. Is the list empty now? " + list.isEmpty());
        System.out.println("Type: " + list.getClass().getName());
    }
}

