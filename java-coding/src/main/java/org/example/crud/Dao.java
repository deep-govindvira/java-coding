package org.example.crud;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student { " +
            "name = '" + name + '\'' +
            " }";
    }
}

public class Dao {

    final static String DATABASE = "jdbc:sqlite:database.db";
    final static String STUDENTS = "students";
    final static String STUDENT_NAME = "name";

    public static void save(Student student) {
        try {
            create();
            DriverManager
                .getConnection(DATABASE)
                .createStatement()
                .execute("INSERT OR REPLACE INTO " + STUDENTS + " (" + STUDENT_NAME + ") VALUES ('" + student.getName() + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Student student) {
        try {
            create();
            DriverManager
                .getConnection(DATABASE)
                .createStatement()
                .execute("DELETE FROM " + STUDENTS + " WHERE " + STUDENT_NAME + " = '" + student.getName() + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete() {
        try {
            create();
            DriverManager
                .getConnection(DATABASE)
                .createStatement()
                .execute("DROP TABLE " + STUDENTS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void create() {
        try {
            DriverManager
                .getConnection(DATABASE)
                .createStatement()
                .execute("CREATE TABLE IF NOT EXISTS " + STUDENTS + " (" + STUDENT_NAME + " VARCHAR(100) PRIMARY KEY)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> getList() {
        List<Student> students = new ArrayList<>();
        try {
            create();
            ResultSet resultSet = DriverManager
                .getConnection(DATABASE)
                .createStatement()
                .executeQuery("SELECT * FROM " + STUDENTS);
            while (resultSet.next()) students.add(new Student(resultSet.getString(STUDENT_NAME)));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public static void main(String[] args) {
        Dao.save(new Student("Dhiraj"));
        Dao.save(new Student("Dhiraj"));
        Dao.delete(new Student("Deep"));
        Dao.save(new Student("Deep"));
        Dao.save(new Student("No Student"));
        Dao.delete(new Student("No Student"));
        System.out.println(Dao.getList());
        Dao.delete();
    }
}
