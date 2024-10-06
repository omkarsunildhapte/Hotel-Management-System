package view.auth;

import controller.auth.UserController;
import view.HotelManager.DashboardPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private static final Color LINK_COLOR = new Color(0, 51, 153);

    public LoginPage() {
        JFrame frame = new JFrame("Hotel Booking System");
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
        placeComponents(panel,frame);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel,JFrame frame) {
        int gridy = 0;
        int gridx = 0;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.setBackground(new Color(245, 245, 245));

        JLabel welcomeLabel = new JLabel("Login");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(70, 130, 180));
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        panel.add(welcomeLabel, constraints);

        gridy++;
        constraints.gridwidth = 1;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(DEFAULT_FONT);
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        panel.add(usernameLabel, constraints);

        JTextField usernameText = new JTextField(20);
        usernameText.setFont(DEFAULT_FONT);
        usernameText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = gridx + 1;
        panel.add(usernameText, constraints);

        gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(DEFAULT_FONT);
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        panel.add(passwordLabel, constraints);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setFont(DEFAULT_FONT);
        passwordText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
        constraints.gridx = gridx + 1;
        panel.add(passwordText, constraints);

        gridy++;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setPreferredSize(new Dimension(150, 30));
        loginButton.setBackground(PRIMARY_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);

        gridy++;
        JLabel registerLabel = new JLabel("<HTML><U>Don't have an account? Register here</U></HTML>");
        registerLabel.setFont(DEFAULT_FONT);
        registerLabel.setForeground(LINK_COLOR);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        panel.add(registerLabel, constraints);

        gridy++;
        JLabel forgetPasswordLabel = new JLabel("<HTML><U>Forget Password</U></HTML>");
        forgetPasswordLabel.setFont(DEFAULT_FONT);
        forgetPasswordLabel.setForeground(LINK_COLOR);
        forgetPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        panel.add(forgetPasswordLabel, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText().trim();
                String password = new String(passwordText.getPassword()).trim();
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    boolean isLogin = UserController.login(username,password);
                    if (isLogin){
                    JOptionPane.showMessageDialog(panel, "Welcome, " + username + "!");
                   if (UserController.role==30){
                    new DashboardPage(username);
                   } else if (UserController.role ==20){

                   } else if (UserController.role ==10){

                   } else if (UserController.role == 5){

                   }
                    frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Login failed Invalid User or password", "Login failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(panel, "Login failed: " + ex.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new RegisterPage();
                frame.dispose();
            }
        });

        forgetPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new ForgetPage();
                frame.dispose();
            }
        });
    }
}
