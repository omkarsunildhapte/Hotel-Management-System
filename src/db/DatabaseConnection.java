package db;

import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/?user=root";
    private static final String username = "root";
    private static final String password = "m^|gA<l=y>W5?";
    private static final String dbName = "hotel-management";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("SQL Connection: " + e.getMessage());
        }
        return null;
    }

    public static void createdDatabase() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database '" + dbName + "' created successfully.");
        } catch (SQLException e) {
            System.out.println("SQL Error (Database Creation): " + e.getMessage());
        }
    }

    public static void createUsersTable() {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "firstName VARCHAR(50), "
                    + "lastName VARCHAR(50), "
                    + "username VARCHAR(50) NOT NULL UNIQUE, "
                    + "email VARCHAR(100) NOT NULL UNIQUE, "
                    + "password VARCHAR(100) NOT NULL, "
                    + "role INT, "
                    + "street_address_1 VARCHAR(100), "
                    + "street_address_2 VARCHAR(100), "
                    + "state VARCHAR(50), "
                    + "city VARCHAR(50), "
                    + "country VARCHAR(50), "
                    + "pincode INT, "
                    + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + "updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
                    + "PRIMARY KEY (id))";

            statement.executeUpdate(createTableSQL);
            System.out.println("Users table created successfully with address fields.");
        } catch (SQLException e) {
            System.out.println("SQL Error (Users Table Creation): " + e.getMessage());
        }
    }

    public static void createHotelsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS hotels (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "username VARCHAR(255) NOT NULL UNIQUE, " +
                "hotel_name VARCHAR(255) NOT NULL, " +
                "rating INT CHECK (rating BETWEEN 1 AND 5), " +
                "address VARCHAR(255), " +
                "city VARCHAR(255), " +
                "state VARCHAR(255), " +
                "country VARCHAR(255), " +
                "pincode INT, " +
                "phone_number VARCHAR(15), " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("Hotels table created successfully.");
        } catch (SQLException e) {
            System.out.println("SQL Error (Create Hotels Table): " + e.getMessage());
        }
    }

}
