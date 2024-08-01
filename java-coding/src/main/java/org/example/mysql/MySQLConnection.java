package org.example.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Replace with your database URL
        String user = "user"; // Replace with your database username
        String password = "password"; // Replace with your database password

        try {
            // Load MySQL JDBC driver (not always necessary in newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection successful!");

            // Use the connection (e.g., to create a statement, execute queries)

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
    }
}

