package org.example.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SQLiteBatchExampleWithPreparedStatement {
    public static void main(String[] args) {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish a connection to an SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");

            // Prepare an SQL statement
            String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Create a Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Get the number of records to insert
            System.out.print("Enter the number of records to insert: ");
            int numberOfRecords = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Add parameters to the batch using a for loop
            for (int i = 0; i < numberOfRecords; i++) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter department: ");
                String department = scanner.nextLine();

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, department);
                preparedStatement.addBatch();
            }

            // Execute the batch
            int[] updateCounts = preparedStatement.executeBatch();

            // Print the results
            for (int count : updateCounts) {
                System.out.println("Rows affected: " + count);
            }

            // Clean up
            preparedStatement.close();
            connection.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
