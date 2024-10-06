package controller.auth;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    private static int id;
    public static String firstName;
    public static String lastName;
    public static String usernameDb;
    public static String email;
    public static int role;

    public static void register(String firstName, String lastName, int role, String email, String username, String password, String streetAddress1, String streetAddress2, String state, String city, String country, int pincode) {
        DatabaseConnection.createUsersTable();
        try {
            String insertSQL = "INSERT INTO users (firstName, lastName, role, email, username, password,street_address_1, street_address_2, state, city, country, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, role);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, streetAddress1);
            preparedStatement.setString(8, streetAddress2);
            preparedStatement.setString(9, state);
            preparedStatement.setString(10, city);
            preparedStatement.setString(11, country);
            preparedStatement.setInt(12, pincode);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("User registered Something issue.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error (User Registration): " + e.getMessage());
        }
    }

    public static boolean login(String username, String password) {
        boolean returnValue = false;
        try {
            String selectSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                usernameDb = resultSet.getString("username");
                email = resultSet.getString("email");
                role = resultSet.getInt("role");
                returnValue = true;
            } else {
                returnValue = false;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error (Login): " + e.getMessage());
            returnValue = false;
        }
        return returnValue;
    }
}
