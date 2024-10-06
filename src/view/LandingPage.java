package view;

import view.auth.LoginPage;
import view.auth.RegisterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage {

    public LandingPage() {
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
        int grindy=0;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.setBackground(new Color(245, 245, 245));

        JLabel welcomeLabel = new JLabel("Welcome to the Hotel Booking System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(70, 130, 180));
        constraints.gridx = 0;
        constraints.gridy = grindy;
        panel.add(welcomeLabel, constraints);
        constraints.gridy = ++grindy;
        panel.add(Box.createRigidArea(new Dimension(0, 30)), constraints);

        JButton loginButton = new JButton("Login");
        styleButton(loginButton, new Color(70, 130, 180), new Dimension(150, 40));
        constraints.gridy = ++grindy;
        panel.add(loginButton, constraints);
        constraints.gridy = ++grindy;
        panel.add(Box.createRigidArea(new Dimension(0, 20)), constraints);

        JButton registerButton = new JButton("Register");
        styleButton(registerButton, new Color(34, 139, 34), new Dimension(150, 40));
        constraints.gridy = ++grindy;
        panel.add(registerButton, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                frame.dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPage();
                frame.dispose();
            }
        });
    }

    private void styleButton(JButton button, Color backgroundColor, Dimension size) {
        button.setPreferredSize(size);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });
    }
}
