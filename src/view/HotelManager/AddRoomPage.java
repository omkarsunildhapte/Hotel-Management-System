package view.HotelManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddRoomPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private JPanel addRoomPanel;
    private JTable roomsTable;
    private DefaultTableModel tableModel;

    public AddRoomPage() {
        addRoomPanel = new JPanel(new GridBagLayout());
        addRoomPanel.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        JLabel titleLabel = new JLabel("Add Room Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addRoomPanel.add(titleLabel, constraints);


        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;


        constraints.gridy++;
        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        addRoomPanel.add(roomTypeLabel, constraints);

        JTextField roomTypeField = new JTextField(20);
        roomTypeField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addRoomPanel.add(roomTypeField, constraints);


        constraints.gridy++;
        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        addRoomPanel.add(roomNumberLabel, constraints);

        JTextField roomNumberField = new JTextField(10);
        roomNumberField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addRoomPanel.add(roomNumberField, constraints);


        constraints.gridy++;
        JLabel priceLabel = new JLabel("Price per Night:");
        priceLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        addRoomPanel.add(priceLabel, constraints);

        JTextField priceField = new JTextField(10);
        priceField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addRoomPanel.add(priceField, constraints);


        constraints.gridy++;
        JLabel roomSizeLabel = new JLabel("Room Size (sq.ft):");
        roomSizeLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        addRoomPanel.add(roomSizeLabel, constraints);

        JTextField roomSizeField = new JTextField(10);
        roomSizeField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addRoomPanel.add(roomSizeField, constraints);


        constraints.gridy++;
        JLabel featuresLabel = new JLabel("Additional Features:");
        featuresLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        addRoomPanel.add(featuresLabel, constraints);

        JTextArea featuresField = new JTextArea(3,20);
        featuresField.setFont(DEFAULT_FONT);;
        featuresField.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = 1;
        addRoomPanel.add(featuresField, constraints);


        constraints.gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(PRIMARY_COLOR);
        submitButton.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        addRoomPanel.add(submitButton, constraints);


        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridy++;


        String[] columnNames = {"Room Type", "Room Number", "Price", "Size", "Features","Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableModel.addRow(new Object[]{"Deluxe", "101", "$200", "350", "Sea View, WiFi","Available"});
        tableModel.addRow(new Object[]{"Suite", "102", "$350", "500", "Private Pool, WiFi, TV","Booked"});
        tableModel.addRow(new Object[]{"Suite", "102", "$350", "500", "Private Pool, WiFi, TV","Work"});

        roomsTable = new JTable(tableModel);
        roomsTable.setFont(DEFAULT_FONT);
        roomsTable.setRowHeight(25);

        JScrollPane tableScrollPane = new JScrollPane(roomsTable);
        addRoomPanel.add(tableScrollPane, constraints);


        submitButton.addActionListener(e -> {
            String roomType = roomTypeField.getText().trim();
            String roomNumber = roomNumberField.getText().trim();
            String pricePerNight = priceField.getText().trim();
            String roomSize = roomSizeField.getText().trim();
            String additionalFeatures = featuresField.getText().trim();


            tableModel.addRow(new Object[]{roomType, roomNumber, "$" + pricePerNight, roomSize, additionalFeatures});
            JOptionPane.showMessageDialog(null, "Room added successfully!");


            roomTypeField.setText("");
            roomNumberField.setText("");
            priceField.setText("");
            roomSizeField.setText("");
            featuresField.setText("");
        });
    }

    public JPanel getAddRoomPanel() {
        return addRoomPanel;
    }
}
