package view.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.auth.UserController;
import util.Validation;
public class RegisterPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private static final Color LINK_COLOR = new Color(0, 51, 153);

    public RegisterPage() {
        JFrame frame = new JFrame("Register");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(240, 248, 255));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        frame.add(panel);
        placeComponents(panel,frame );
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel,JFrame frame) {
        int grindy = 0;
        int grindx = 0;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.setBackground(new Color(245, 245, 245));

        JLabel welcomeLabel = new JLabel("Register");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(70, 130, 180));
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        constraints.gridwidth = 2;
        panel.add(welcomeLabel, constraints);

        grindy++;
        constraints.gridwidth = 1;
        JLabel nameLabel = new JLabel("First Name:");
        nameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(nameLabel, constraints);

        JTextField nameText = new JTextField(20);
        nameText.setFont(DEFAULT_FONT);
        nameText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(nameText, constraints);

        grindy++;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(lastNameLabel, constraints);

        JTextField lastNameText = new JTextField(20);
        lastNameText.setFont(DEFAULT_FONT);
        lastNameText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(lastNameText, constraints);

        grindy++;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(usernameLabel, constraints);

        JTextField usernameText = new JTextField(20);
        usernameText.setFont(DEFAULT_FONT);
        usernameText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(usernameText, constraints);

        grindy++;
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(phoneNumberLabel, constraints);

        JTextField phoneNumberText = new JTextField(20);
        phoneNumberText.setFont(DEFAULT_FONT);
        phoneNumberText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(phoneNumberText, constraints);

        grindy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(emailLabel, constraints);

        JTextField emailText = new JTextField(20);
        emailText.setFont(DEFAULT_FONT);
        emailText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(emailText, constraints);


        grindy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(passwordLabel, constraints);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setFont(DEFAULT_FONT);
        passwordText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(passwordText, constraints);

        grindy++;
        JLabel passwordConfirmLabel = new JLabel("Confirm Password:");
        passwordConfirmLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(passwordConfirmLabel, constraints);

        JPasswordField passwordConfirmText = new JPasswordField(20);
        passwordConfirmText.setFont(DEFAULT_FONT);
        passwordConfirmText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(passwordConfirmText, constraints);

        grindy++;
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(roleLabel, constraints);

        String[] roles = {"User", "Worker", "Manager"};
        JComboBox<String> roleDropdown = new JComboBox<>(roles);
        roleDropdown.setFont(DEFAULT_FONT);
        roleDropdown.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(roleDropdown, constraints);

        grindy++;
        JLabel streetAddressLabel1 = new JLabel("Address Line 1:");
        streetAddressLabel1.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(streetAddressLabel1, constraints);

        JTextArea streetAddressText1 = new JTextArea(3, 20);
        streetAddressText1.setFont(DEFAULT_FONT);
        streetAddressText1.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(streetAddressText1, constraints);

        grindy++;
        JLabel streetAddressLabel2 = new JLabel("Address Line 2:");
        streetAddressLabel2.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(streetAddressLabel2, constraints);

        JTextArea streetAddressText2 = new JTextArea(3, 20);
        streetAddressText2.setFont(DEFAULT_FONT);
        streetAddressText2.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(streetAddressText2, constraints);

        grindy++;
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(cityLabel, constraints);

        JTextField cityText = new JTextField(20);
        cityText.setFont(DEFAULT_FONT);
        cityText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(cityText, constraints);

        grindy++;
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(stateLabel, constraints);

        JTextField stateText = new JTextField(20);
        stateText.setFont(DEFAULT_FONT);
        stateText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(stateText, constraints);

        grindy++;
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(countryLabel, constraints);

        JTextField countryText = new JTextField(20);
        countryText.setFont(DEFAULT_FONT);
        countryText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(countryText, constraints);

        grindy++;
        JLabel pinCodeLabel = new JLabel("Pin Code:");
        pinCodeLabel.setFont(DEFAULT_FONT);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        panel.add(pinCodeLabel, constraints);

        JTextField pinCodeText = new JTextField(20);
        pinCodeText.setFont(DEFAULT_FONT);
        pinCodeText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = grindx + 1;
        panel.add(pinCodeText, constraints);

        grindy++;
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setPreferredSize(new Dimension(150, 30));
        registerButton.setBackground(PRIMARY_COLOR);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        constraints.gridwidth = 2;
        panel.add(registerButton, constraints);

        grindy++;
        JLabel loginLabel = new JLabel("<HTML><U>Already have an account? Login here</U></HTML>");
        loginLabel.setFont(DEFAULT_FONT);
        loginLabel.setForeground(LINK_COLOR);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        constraints.gridx = grindx;
        constraints.gridy = grindy;
        constraints.gridwidth = 2;
        panel.add(loginLabel, constraints);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = nameText.getText().trim();
                String lastName = lastNameText.getText().trim();
                String email = emailText.getText().trim();
                String phoneNumber = phoneNumberText.getText().trim();
                String username = usernameText.getText().trim();
                String password = new String(passwordText.getPassword()).trim();
                String confirmPassword = new String(passwordConfirmText.getPassword()).trim();
                String role = (String) roleDropdown.getSelectedItem();
                String streetAddress1 = streetAddressText1.getText().trim();
                String streetAddress2 = streetAddressText2.getText().trim();;
                String state = stateText.getText().trim();
                String city = cityText.getText().trim();
                String country = countryText.getText().trim();
                String pincode = pinCodeText.getText().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                        username.isEmpty() || password.isEmpty() || role.isEmpty() ||
                        streetAddress1.isEmpty() || state.isEmpty() || city.isEmpty() ||
                        country.isEmpty() || pincode.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Validation.isValidEmail(email)) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Validation.isValidPhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid phone number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!confirmPassword.equals(password)) {
                    JOptionPane.showMessageDialog(panel, "Please enter a Conform Password.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int roleNumber = 0;
                if (role.equals("User")) {
                    roleNumber = 10;
                } else if (role.equals("Worker")) {
                    roleNumber = 20;
                } else if (role.equals("Manager")) {
                    roleNumber = 30;
                }

                try {
                    UserController.register(firstName, lastName, roleNumber, email, username, password, streetAddress1, streetAddress2, state, city, country, Integer.parseInt(pincode));
                    JOptionPane.showMessageDialog(panel, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new LoginPage();
                    frame.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Registration failed: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
                }            }
        });

        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new LoginPage();
                frame.dispose();
            }
        });
    }
}
