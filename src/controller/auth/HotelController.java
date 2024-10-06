package controller.auth;

import db.DatabaseConnection;
import model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelController {
    public static void insertHotel(String username, String hotelName, int rating, String address, String city,
                                   String state, String country, int pincode, String phoneNumber) {
        String insertSQL = "INSERT INTO hotels (username, hotel_name, rating, address, city, state, country, pincode, phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hotelName);
            preparedStatement.setInt(3, rating);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, state);
            preparedStatement.setString(7, country);
            preparedStatement.setInt(8, pincode);
            preparedStatement.setString(9, phoneNumber);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Hotel inserted successfully.");
            } else {
                System.out.println("Failed to insert hotel.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error (Insert Hotel): " + e.getMessage());
        }
    }

    public static void updateHotel(int id, String hotelName, int rating, String address, String city,
                                   String state, String country, int pincode, String phoneNumber) {
        String updateSQL = "UPDATE hotels SET hotel_name = ?, rating = ?, address = ?, city = ?, state = ?, " +
                "country = ?, pincode = ?, phone_number = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, hotelName);
            preparedStatement.setInt(2, rating);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, state);
            preparedStatement.setString(6, country);
            preparedStatement.setInt(7, pincode);
            preparedStatement.setString(8, phoneNumber);
            preparedStatement.setInt(9, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Hotel updated successfully.");
            } else {
                System.out.println("Failed to update hotel.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error (Update Hotel): " + e.getMessage());
        }
    }

    public static Hotel getHotelByUsername(String username) {
        String selectSQL = "SELECT * FROM hotels WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Hotel(
                        resultSet.getInt("id"),
                        resultSet.getString("hotel_name"),
                        resultSet.getInt("rating"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("country"),
                        resultSet.getInt("pincode"),
                        resultSet.getString("phone_number")
                );
            } else {
                System.out.println("No hotel found for username: " + username);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("SQL Error (Get Hotel by Username): " + e.getMessage());
        }
        return null;
    }
}
