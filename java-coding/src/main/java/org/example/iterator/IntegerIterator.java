package org.example.iterator;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

interface IterableCollection<T> {
    Iterator<T> iterator();
}


class IntegerCollection implements IterableCollection<Integer> {
    private List<Integer> items;

    public IntegerCollection() {
        items = new ArrayList<>();
    }

    public void add(Integer item) {
        items.add(item);
    }

    public Integer get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator(this);
    }
}


public class IntegerIterator implements Iterator<Integer> {
    private IntegerCollection collection;
    private int index;

    public IntegerIterator(IntegerCollection collection) {
        this.collection = collection;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public Integer next() {
        return collection.get(index++);
    }

    public static void main(String[] args) {
        IntegerCollection collection = new IntegerCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }

}
