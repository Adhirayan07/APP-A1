import javax.swing.*;
import java.awt.*;

public class UserLoginPreferences extends JFrame {
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JCheckBox remember = new JCheckBox("Remember Me");
    JCheckBox notifications = new JCheckBox("Receive Notifications");

    UserLoginPreferences() {
        setTitle("User Login");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Username")); add(userField);
        add(new JLabel("Password")); add(passField);
        add(remember); add(notifications);

        JButton login = new JButton("Login");
        add(new JLabel()); add(login);

        login.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("admin123"))
                JOptionPane.showMessageDialog(this,
                    "Login successful\nRemember Me: " + remember.isSelected() +
                    "\nNotifications: " + notifications.isSelected());
            else
                JOptionPane.showMessageDialog(this, "Invalid username or password",
                    "Login Error", JOptionPane.ERROR_MESSAGE);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLoginPreferences();
    }
}
