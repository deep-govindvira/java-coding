package org.example.LFUCache;

import java.util.*;

class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> cache;  // Key -> Node
    private final Map<Integer, LinkedHashSet<Node>> freqMap; // Frequency -> Nodes

    static class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;  // Initial frequency is 1
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (cache.size() >= capacity) evict();
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1;  // Reset min frequency
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).isEmpty() && freq == minFreq) minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    private void evict() {
        Node evictNode = freqMap.get(minFreq).iterator().next();
        freqMap.get(minFreq).remove(evictNode);
        cache.remove(evictNode.key);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1)); // Returns 1
        lfu.put(3, 3);  // Evicts key 2
        System.out.println(lfu.get(2)); // Returns -1 (not found)
        System.out.println(lfu.get(3)); // Returns 3
    }
}
