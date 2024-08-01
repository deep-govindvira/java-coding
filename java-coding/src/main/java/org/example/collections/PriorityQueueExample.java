package org.example.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(20);
        pq.add(15);

        System.out.println("PriorityQueue: " + pq);
        System.out.println("Head of the queue: " + pq.peek());

        System.out.println("Removed element: " + pq.poll());
        System.out.println("PriorityQueue after removal: " + pq);

        System.out.println("Size of the PriorityQueue: " + pq.size());

        System.out.println();
        CustomPriorityQueue.main(new String[0]);
    }
}

class CustomPriorityQueue {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);
        System.out.print("PriorityQueue : ");
        while(!priorityQueue.isEmpty()) System.out.print(priorityQueue.poll() + " ");
    }
}

