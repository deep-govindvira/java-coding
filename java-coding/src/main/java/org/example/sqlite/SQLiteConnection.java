package org.example.sqlite;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLiteConnection {
    private static Connection connection;

    private static void connectSQLite() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle exception appropriately
        }
    }

    public static void create(String createTableSQL) {
        if(connection == null)  connectSQLite();
        if(connection != null) {
            // Create the table
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Table created successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void insert(String insertSQL) {
        if(connection == null) connectSQLite();
        if(connection != null) {
            // Insert data into the table
            try (Statement statement = connection.createStatement()) {
                statement.execute(insertSQL);
                System.out.println("Data inserted successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void select(String selectSql) {
        if(connection == null) connectSQLite();
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSql);

                // Get metadata to retrieve column names
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Print column names
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println();

                // Print rows
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void drop(String dropSQL) {
        if(connection == null)  connectSQLite();
        if(connection != null) {
            // Drop the table
            try (Statement statement = connection.createStatement()) {
                statement.execute(dropSQL);
                System.out.println("Table dropped successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}