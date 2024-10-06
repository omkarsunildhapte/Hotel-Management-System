package view.HotelManager;

import controller.auth.HotelController;
import model.Hotel;

import javax.swing.*;
import java.awt.*;


public class AddHotelPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private JPanel addHotelPanel;
    private JTextField nameField;
    private JTextField hotelRatingField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField countryField;
    private JTextField pincodeField;
    private JTextField phoneField;
    private  int id;
    private String username;

    public AddHotelPage() {
        int gridx = 0;
        int gridy = 0;
        addHotelPanel = new JPanel(new GridBagLayout());
        addHotelPanel.setBackground(Color.WHITE);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
            // Title
        JLabel titleLabel = new JLabel("Add/Update Hotel Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        addHotelPanel.add(titleLabel, constraints);

        // Hotel Name
        gridy++;
        JLabel nameLabel = new JLabel("Hotel Name:");
        nameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 1;
        addHotelPanel.add(nameLabel, constraints);

        nameField = new JTextField(20);
        nameField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(nameField, constraints);

        gridy++;
        JLabel hotelRating = new JLabel("Rating:");
        hotelRating.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 1;
        addHotelPanel.add(hotelRating, constraints);

        hotelRatingField = new JTextField(20);
        hotelRatingField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(hotelRatingField, constraints);

        // Address
        gridy++;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(addressLabel, constraints);

        addressField = new JTextField(20);
        addressField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(addressField, constraints);

        // City
        gridy++;
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(cityLabel, constraints);

        cityField = new JTextField(15);
        cityField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(cityField, constraints);

        // State
        gridy++;
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(stateLabel, constraints);

        stateField = new JTextField(15);
        stateField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(stateField, constraints);

        // Country
        gridy++;
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(countryLabel, constraints);

        countryField = new JTextField(15);
        countryField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(countryField, constraints);

        // Pincode
        gridy++;
        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(pincodeLabel, constraints);

        pincodeField = new JTextField(10);
        pincodeField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(pincodeField, constraints);

        // Phone Number
        gridy++;
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addHotelPanel.add(phoneLabel, constraints);

        phoneField = new JTextField(15);
        phoneField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addHotelPanel.add(phoneField, constraints);


        // Submit Button
        gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(PRIMARY_COLOR);
        submitButton.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        addHotelPanel.add(submitButton, constraints);

        submitButton.addActionListener(e -> {
            String hotelName = nameField.getText().trim();
            String hotelRatingFields = hotelRatingField.getText().trim();
            String hotelAddress = addressField.getText().trim();
            String city = cityField.getText().trim();
            String state = stateField.getText().trim();
            String country = countryField.getText().trim();
            String pincode = pincodeField.getText().trim();
            String phoneNumber = phoneField.getText().trim();

            int hotelRatings;
            try {
                hotelRatings = Integer.parseInt(hotelRatingFields);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addHotelPanel, "Rating must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Hotel.getId() != 0) {
                HotelController.updateHotel(Hotel.getId(), hotelName, hotelRatings, hotelAddress, city, state, country, Integer.parseInt(pincode), phoneNumber);
            } else {
                HotelController.insertHotel(username, hotelName, hotelRatings, hotelAddress, city, state, country, Integer.parseInt(pincode), phoneNumber);
            }

            JOptionPane.showMessageDialog(addHotelPanel, "Hotel details saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

    }

    public JPanel getAddHotelPanel(String username) {
        Hotel hotel = HotelController.getHotelByUsername(username);
        this.username =username;
        if (hotel != null) {
            nameField.setText(hotel.getHotelName());
            hotelRatingField.setText(String.valueOf(hotel.getRating()));
            addressField.setText(hotel.getAddress());
            cityField.setText(hotel.getCity());
            stateField.setText(hotel.getState());
            countryField.setText(hotel.getCountry());
            pincodeField.setText(String.valueOf(hotel.getPincode()));
            phoneField.setText(hotel.getPhoneNumber());
            id = hotel.getId();
        }
        return addHotelPanel;
    }
}
