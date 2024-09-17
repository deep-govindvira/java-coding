package org.example.participation;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    // Constructor to ensure the student starts with at least one course
    public Student(String name, Course course) {
        this.name = name;
        this.courses = new ArrayList<>();
        enroll(course);  // Ensure initial course is added correctly
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Enroll in an additional course
    public void enroll(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);  // Maintain bidirectional consistency
        }
    }
}

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enroll(this);  // Maintain bidirectional consistency
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course physics = new Course("Physics");

        // Create students with initial course to ensure total participation
        Student john = new Student("John Doe", math);  // Enrolled in Mathematics
        john.enroll(physics);  // Also enroll in Physics
        Student jane = new Student("Jane Smith", science);  // Enrolled in Science

        // Output students and their courses
        System.out.println(john.getName() + " is enrolled in: ");
        for (Course course : john.getCourses()) {
            System.out.println(course.getCourseName());
        }

        System.out.println(jane.getName() + " is enrolled in: ");
        for (Course course : jane.getCourses()) {
            System.out.println(course.getCourseName());
        }

        // Output courses and their students
        System.out.println(math.getCourseName() + " has students: ");
        for (Student student : math.getStudents()) {
            System.out.println(student.getName());
        }

        System.out.println(science.getCourseName() + " has students: ");
        for (Student student : science.getStudents()) {
            System.out.println(student.getName());
        }

        System.out.println(physics.getCourseName() + " has students: ");
        for (Student student : physics.getStudents()) {
            System.out.println(student.getName());
        }
    }
}

