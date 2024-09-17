package org.example.sqlite;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CRUD {
    public static void main(String[] args) {
        // SQLiteConnection.create("CREATE TABLE employees (\n" +
        //     "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        //     "    name TEXT NOT NULL,\n" +
        //     "    department TEXT NOT NULL\n" +
        //     ");\n");
        SQLiteConnection.insert("INSERT INTO employees (name, department) VALUES ('deep', 'IT')");
        // SQLiteConnection.create("create table if not exists users (id integer primary key, name text, password text);");
        // SQLiteConnection.insert("insert into users values (1, 'hello', 'p1a2s3s')," +
        //     "(2, 'world', 'hacked')");
        // SQLiteConnection.select("select * from users");

        // SQLiteConnection.update("update users set name = 'hi' where name = 'hello'");
        // SQLiteConnection.select("select * from users");
        // SQLiteConnection.drop("drop table users");
    }
}
