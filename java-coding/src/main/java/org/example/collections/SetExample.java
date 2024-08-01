package org.example.collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    int marks;
    String name;

    Student(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}

public class SetExample {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student(5, "hello"));
        System.out.println(set.add(new Student(23, "hello")));
        set.add(new Student(10, "world"));

        for (Student student : set) {
            System.out.println(student);
        }
    }
}
