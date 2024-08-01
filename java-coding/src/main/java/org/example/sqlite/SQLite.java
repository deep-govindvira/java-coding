package org.example.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLite {

    private static void connection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from students", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
    }

    public static void main(String[] args) {
    }
}
