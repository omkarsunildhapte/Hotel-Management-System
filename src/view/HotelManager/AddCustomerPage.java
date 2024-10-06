package view.HotelManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class AddCustomerPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private JPanel addCustomerPanel;
    private JTable customersTable;

    public AddCustomerPage() {
        int gridx = 0;
        int gridy = 0;
        addCustomerPanel = new JPanel(new GridBagLayout());
        addCustomerPanel.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Add Customer Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addCustomerPanel.add(titleLabel, constraints);

        // Reset gridwidth after title
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;

        // Customer Name
        gridy++;
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(nameLabel, constraints);

        JTextField nameField = new JTextField(20);
        nameField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addCustomerPanel.add(nameField, constraints);

        // Email
        gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(emailLabel, constraints);

        JTextField emailField = new JTextField(20);
        emailField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addCustomerPanel.add(emailField, constraints);

        // Phone Number
        gridy++;
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(phoneLabel, constraints);

        JTextField phoneField = new JTextField(15);
        phoneField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addCustomerPanel.add(phoneField, constraints);

        // Address
        gridy++;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(addressLabel, constraints);

        JTextField addressField = new JTextField(20);
        addressField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addCustomerPanel.add(addressField, constraints);

        // Aadhaar ID / PAN ID
        gridy++;
        JLabel aadhaarLabel = new JLabel("Aadhaar ID / PAN ID:");
        aadhaarLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(aadhaarLabel, constraints);

        JTextField nationalIdField = new JTextField(12);
        nationalIdField.setFont(DEFAULT_FONT);
        constraints.gridx = 1;
        addCustomerPanel.add(nationalIdField, constraints);

        // Is Part of a Group
        gridy++;
        JLabel groupLabel = new JLabel("Is part of a group?");
        groupLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(groupLabel, constraints);

        JCheckBox groupCheckBox = new JCheckBox();
        constraints.gridx = 1;
        addCustomerPanel.add(groupCheckBox, constraints);

        // Check-In Date
        gridy++;
        JLabel checkInLabel = new JLabel("Check-In Date:");
        checkInLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(checkInLabel, constraints);

        JSpinner checkInSpinner = new JSpinner(new SpinnerDateModel());
        checkInSpinner.setFont(DEFAULT_FONT);
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(checkInSpinner, "dd/MM/yyyy");
        checkInSpinner.setEditor(checkInEditor);
        constraints.gridx = 1;
        addCustomerPanel.add(checkInSpinner, constraints);

// Check-Out Date
        gridy++;
        JLabel checkOutLabel = new JLabel("Check-Out Date:");
        checkOutLabel.setFont(DEFAULT_FONT);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        addCustomerPanel.add(checkOutLabel, constraints);

        JSpinner checkOutSpinner = new JSpinner(new SpinnerDateModel());
        checkOutSpinner.setFont(DEFAULT_FONT);
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(checkOutSpinner, "dd/MM/yyyy");
        checkOutSpinner.setEditor(checkOutEditor);
        constraints.gridx = 1;
        addCustomerPanel.add(checkOutSpinner, constraints);

        // Submit Button
        gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(PRIMARY_COLOR);
        submitButton.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addCustomerPanel.add(submitButton, constraints);

        // Reset gridwidth for table
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        // Table for customer details
        gridy++;
        String[] columnNames = {"Customer Name", "Email", "Phone Number", "Address", "Aadhaar ID", "PAN ID", "Check-In", "Check-Out", "Is Group", "Action"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Sample rows (replace with actual data)
        tableModel.addRow(new Object[]{"John Doe", "john@example.com", "1234567890", "123 Main St", "111122223333", "ABCDE1234F", "01/10/2024", "05/10/2024", "No", "Edit"});
        tableModel.addRow(new Object[]{"Jane Smith", "jane@example.com", "9876543210", "456 Elm St", "222233334444", "XYZ98765P", "02/10/2024", "06/10/2024", "Yes", "Edit"});

        customersTable = new JTable(tableModel);
        customersTable.setFont(DEFAULT_FONT);
        customersTable.setRowHeight(25);

        JScrollPane tableScrollPane = new JScrollPane(customersTable);
        constraints.gridy = gridy;
        addCustomerPanel.add(tableScrollPane, constraints);

        // Button ActionListener for form submission
        submitButton.addActionListener(e -> {
            String customerName = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phoneNumber = phoneField.getText().trim();
            String address = addressField.getText().trim();
            String nationalId = nationalIdField.getText().trim();
            Date checkInDate = (Date) checkInSpinner.getValue();
            Date checkOutDate = (Date) checkOutSpinner.getValue();
            String isGroup = groupCheckBox.isSelected() ? "Yes" : "No";

            // Add the new customer data to the table
            tableModel.addRow(new Object[]{customerName, email, phoneNumber, address, nationalId, checkInDate, checkOutDate, isGroup, "Edit"});
            JOptionPane.showMessageDialog(null, "Customer added successfully!");

            // Clear form fields after submission
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressField.setText("");
            nationalIdField.setText("");
            checkInSpinner.setValue(new Date());
            checkOutSpinner.setValue(new Date());
            groupCheckBox.setSelected(false);
        });

        // Action buttons (Edit / Checkout) for the table
        customersTable.getColumnModel().getColumn(9).setCellEditor(new CustomerPageAction(new JTextField()));
    }

    public JPanel getAddCustomerPanel() {
        return addCustomerPanel;
    }
}
