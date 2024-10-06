package view.HotelManager;

import view.auth.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardPage {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color PRIMARY_COLOR = new Color(0, 102, 204);
    private static final Color MENU_ITEM_COLOR = Color.WHITE;
    private String username;

    public DashboardPage(String username) {
        this.username = username;
        JFrame frame = new JFrame("Dashboard");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();

        JLabel headerTitle = new JLabel("Hotel Management", JLabel.CENTER);
        headerTitle.setFont(new Font("Arial", Font.BOLD, 18));
        headerTitle.setForeground(PRIMARY_COLOR);
        headerPanel.add(headerTitle, BorderLayout.CENTER);

        // Side menu setup...
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setLayout(new GridLayout(7, 1));
        sideMenuPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        sideMenuPanel.setBackground(PRIMARY_COLOR);

        String[] menuItems = {"Dashboard", "Manage Hotel", "Manage Room", "Manage Staff", "Manage Customers", "Logout"};
        for (String item : menuItems) {
            JButton menuItemButton = createMenuItemButton(item);
            sideMenuPanel.add(menuItemButton);
        }

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());
        contentPanel.setBackground(Color.WHITE);

        JPanel dashboardContent = new JPanel();
        dashboardContent.add(new JLabel("Welcome to Dashboard " + username));
        contentPanel.add(dashboardContent, "Dashboard");

        AddHotelPage addHotelPage = new AddHotelPage();
        contentPanel.add(addHotelPage.getAddHotelPanel(username), "Manage Hotel");

        AddRoomPage addRoomPage = new AddRoomPage();
        contentPanel.add(addRoomPage.getAddRoomPanel(), "Manage Room");

        AddCustomerPage addCustomer = new AddCustomerPage();
        contentPanel.add(addCustomer.getAddCustomerPanel(), "Manage Customers");

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sideMenuPanel, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        for (Component component : sideMenuPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton menuItemButton = (JButton) component;
                menuItemButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cl = (CardLayout) contentPanel.getLayout();
                        String buttonText = menuItemButton.getText();
                        if (buttonText.equals("Logout")) {
                            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                frame.dispose();
                                new LoginPage();
                            }
                        } else {
                            cl.show(contentPanel, buttonText);
                        }
                    }
                });
            }
        }
    }

    private JButton createMenuItemButton(String text) {
        JButton button = new JButton(text);
        button.setFont(DEFAULT_FONT);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(MENU_ITEM_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }
}
