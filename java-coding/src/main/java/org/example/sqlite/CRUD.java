package org.example.sqlite;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CRUD {
    public static void main(String[] args) {
        SQLiteConnection.create("create table users (name text, password text);");
        SQLiteConnection.insert("insert into users (name, password) values('deep', 'deep/20/12/2004')");
        SQLiteConnection.insert("insert into users (name, password) values('dhiraj', 'dhiraj/01/11/2000')");
        SQLiteConnection.select("select * from users;");
        SQLiteConnection.drop("drop table users");
        Set<Integer> s = new HashSet<>();
        s.add(5);
        s.add(2);
        s.add(7);
        for(Integer i : s) {
            System.out.println(i);
        }
        s = new TreeSet<>();
        s.add(6);
        s.add(4);
        s.add(9);
        for(Integer i : s) {
            System.out.println(i);
        }
    }
}
