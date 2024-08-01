package org.example.sqlite;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLiteConnection {
    private static Connection connection;

    private static void connectSQLite() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            println("Connected to the database.");
        } catch (SQLException e) {
            println(e.getMessage());
        }
    }

    public static void create(String createSQL) {
        if(connection == null)  connectSQLite();
        if(connection != null) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(createSQL);
                println("Table created successfully.");
            } catch (SQLException e) {
                println(e.getMessage());
            }
        }
    }
    public static void insert(String insertSQL) {
        if(connection == null) connectSQLite();
        if(connection != null) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(insertSQL);
                println("Data inserted successfully.");
            } catch (SQLException e) {
                println(e.getMessage());
            }
        }
    }

    public static void update(String updateSql) {
        if(connection == null) connectSQLite();
        if(connection != null) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(updateSql);
                println("Data updated successfully.");
            } catch (SQLException e) {
                println(e.getMessage());
            }
        }
    }

    public static void select(String selectSql) {
        if(connection == null) connectSQLite();
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(selectSql);
                ResultSet resultSet = statement.getResultSet();

                // Get metadata to retrieve column names
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();

                println("columnCount : " + resultSetMetaData.getColumnCount());
                println("columnName : " + resultSetMetaData.getColumnName(1));
                println("columnLabel : " + resultSetMetaData.getColumnLabel(1));
                println("columnType : " + resultSetMetaData.getColumnType(1));
                println("columnTypeName : " + resultSetMetaData.getColumnTypeName(1));
                println("columnClassName : " + resultSetMetaData.getColumnClassName(1));
                println("tableName : " + resultSetMetaData.getTableName(1));
                println("schemaName : " + resultSetMetaData.getSchemaName(1));
                println("class : " + resultSetMetaData.getClass());



                // Print column names
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSetMetaData.getColumnName(i) + "\t");
                }
                System.out.println();

                // Print rows
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        println(resultSet.getString(i) + "\t");
                    }
                    println("");
                }
            }
            catch (SQLException e) {
                println(e.getMessage());
            }
        }
    }

    public static void drop(String dropSQL) {
        if(connection == null)  connectSQLite();
        if(connection != null) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(dropSQL);
                println("Table dropped successfully.");
            } catch (SQLException e) {
                println(e.getMessage());
            }
        }
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void println(String string) {
        System.out.println(string);
    }
}