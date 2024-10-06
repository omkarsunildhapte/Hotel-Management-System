package view.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private static final Color LINK_COLOR = new Color(0, 51, 153);
    public ForgetPage(){
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
     public static  void  placeComponents(JPanel panel, JFrame frame){
         int grindy = 0;
         int grindx = 0;
         GridBagConstraints constraints = new GridBagConstraints();
         constraints.insets = new Insets(10, 10, 10, 10);
         constraints.fill = GridBagConstraints.HORIZONTAL;
         panel.setBackground(new Color(245, 245, 245));

         JLabel welcomeLabel = new JLabel("Forget");
         welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
         welcomeLabel.setForeground(new Color(70, 130, 180));
         constraints.gridx = grindx;
         constraints.gridy = grindy;
         constraints.gridwidth = 2;
         panel.add(welcomeLabel, constraints);

         grindy++;
         constraints.gridwidth = 1;
         JLabel usernameLabel = new JLabel("User Name:");
         usernameLabel.setFont(DEFAULT_FONT);
         constraints.gridx = grindx;
         constraints.gridy = grindy;
         constraints.anchor = GridBagConstraints.CENTER;
         panel.add(usernameLabel, constraints);

         JTextField usernameText = new JTextField(20);
         usernameText.setFont(DEFAULT_FONT);
         usernameText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
         constraints.gridx = grindx + 1;
         panel.add(usernameText, constraints);

         grindy++;
         constraints.gridwidth = 1;
         JLabel passwordLabel = new JLabel("New Password:");
         passwordLabel.setFont(DEFAULT_FONT);
         constraints.gridx = grindx;
         constraints.gridy = grindy;
         constraints.anchor = GridBagConstraints.CENTER;
         panel.add(passwordLabel, constraints);

         JTextField passwordText = new JTextField(20);
         passwordText.setFont(DEFAULT_FONT);
         passwordText.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
         constraints.gridx = grindx + 1;
         panel.add(passwordText, constraints);

         grindy++;
         JButton registerButton = new JButton("Forget Password");
         registerButton.setFont(new Font("Arial", Font.BOLD, 16));
         registerButton.setPreferredSize(new Dimension(150, 30));
         registerButton.setBackground(PRIMARY_COLOR);
         registerButton.setForeground(Color.WHITE);
         registerButton.setFocusPainted(false);
         constraints.gridx = grindx;
         constraints.gridy = grindy;
         constraints.gridwidth = 2;
         panel.add(registerButton, constraints);


         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String username = usernameText.getText().trim();
                 String password = passwordText.getText().trim();

                 if (password.isEmpty() && username.isEmpty() ) {
                     JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
             }
         });

         grindy++;
         JLabel loginLabel = new JLabel("<HTML><U>Already have an account? Login here</U></HTML>");
         loginLabel.setFont(DEFAULT_FONT);
         loginLabel.setForeground(LINK_COLOR);
         loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         constraints.gridx = grindx;
         constraints.gridy = grindy;
         constraints.gridwidth = 2;
         panel.add(loginLabel, constraints);
     }
}
