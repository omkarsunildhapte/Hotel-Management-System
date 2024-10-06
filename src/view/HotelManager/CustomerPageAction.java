package view.HotelManager;

import javax.swing.*;
import java.awt.*;

public class CustomerPageAction extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean clicked;

    public CustomerPageAction(JTextField textField) {
        super(textField);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "Edit" : value.toString();
        button.setText(label);
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            int userChoice = JOptionPane.showOptionDialog(button,
                    "Do you want to Edit or Checkout this customer?",
                    "Customer Action",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Edit", "Checkout"},
                    "Edit");

            if (userChoice == JOptionPane.YES_OPTION) {
                // Edit logic
                JOptionPane.showMessageDialog(button, "Edit customer details!");
                // Implement your edit logic here, e.g., opening an edit dialog.
            } else if (userChoice == JOptionPane.NO_OPTION) {
                // Checkout logic
                int confirmCheckout = JOptionPane.showConfirmDialog(button,
                        "Are you sure you want to checkout this customer?",
                        "Confirm Checkout",
                        JOptionPane.YES_NO_OPTION);
                if (confirmCheckout == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(button, "Customer checked out successfully!");
                    // Implement your checkout logic here, e.g., updating the database, removing the customer from the table, etc.
                }
            }
        }
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
