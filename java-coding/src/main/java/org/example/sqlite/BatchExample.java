package org.example.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite" +
            "://localhost:3306/database";
        String user = "user";
        String password = "password";
        // SQL statements
        String createTableSQL = "CREATE TABLE IF NOT EXISTS your_table (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "column1 VARCHAR(255) NOT NULL, " +
            "column2 VARCHAR(255) NOT NULL)";
        String insertSQL = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL);
             Scanner scanner = new Scanner(System.in)) {

            // Turn off auto-commit
            conn.setAutoCommit(false);

            // Create table if it does not exist
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created if not exists.");

            System.out.print("Enter the number of records to insert: ");
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter value for column1: ");
                String column1Value = scanner.next();

                System.out.print("Enter value for column2: ");
                String column2Value = scanner.next();

                pstmt.setString(1, column1Value);
                pstmt.setString(2, column2Value);
                pstmt.addBatch();
            }

            try {
                pstmt.executeBatch(); // Execute batch
                conn.commit(); // Commit transaction
                System.out.println("Records inserted successfully.");
            } catch (SQLException e) {
                System.out.println("Transaction failed. Rolling back...");
                conn.rollback(); // Rollback in case of failure
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
