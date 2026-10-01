import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class EmployeeModel {
    ArrayList<String[]> employees = new ArrayList<>();
    String password = "admin123";

    boolean login(String user, String pass) {
        return user.equals("admin") && pass.equals(password);
    }

    void addEmployee(String id, String name, String dept) {
        employees.add(new String[]{id, name, dept});
    }

    String viewEmployees() {
        if (employees.isEmpty()) return "No employees added.";

        StringBuilder s = new StringBuilder();
        for (String[] e : employees)
            s.append("ID: ").append(e[0])
             .append(" | Name: ").append(e[1])
             .append(" | Department: ").append(e[2]).append("\n");
        return s.toString();
    }

    boolean changePassword(String oldPass, String newPass, String confirm) {
        if (!password.equals(oldPass) || !newPass.equals(confirm) || newPass.isEmpty())
            return false;
        password = newPass;
        return true;
    }
}

public class EmployeeManagementPortal {
    EmployeeModel model = new EmployeeModel();

    void loginWindow() {
        JFrame f = new JFrame("Employee Portal Login");
        f.setSize(350, 220);
        f.setLayout(new GridLayout(3, 2, 10, 10));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");

        f.add(new JLabel("Username")); f.add(user);
        f.add(new JLabel("Password")); f.add(pass);
        f.add(new JLabel()); f.add(login);

        login.addActionListener(e -> {
            if (model.login(user.getText(), new String(pass.getPassword()))) {
                f.dispose();
                mainWindow();
            } else {
                JOptionPane.showMessageDialog(f, "Invalid credentials.");
            }
        });

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    void mainWindow() {
        JFrame f = new JFrame("Employee Management Portal");
        f.setSize(600, 350);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        JMenuItem add = new JMenuItem("Add Employee");
        JMenuItem view = new JMenuItem("View Employee");
        employee.add(add);
        employee.add(view);

        JMenu tools = new JMenu("Tools");
        JMenuItem change = new JMenuItem("Change Password");
        tools.add(change);

        JMenu exit = new JMenu("Exit");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem exitApp = new JMenuItem("Exit Application");
        exit.add(logout);
        exit.add(exitApp);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);
        f.setJMenuBar(bar);

        f.add(new JLabel("Employee Management Portal", SwingConstants.CENTER));

        add.addActionListener(e -> {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                "Employee ID:", id,
                "Employee Name:", name,
                "Department:", dept
            };

            int result = JOptionPane.showConfirmDialog(
                f, fields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                model.addEmployee(id.getText(), name.getText(), dept.getText());
                JOptionPane.showMessageDialog(f, "Employee added.");
            }
        });

        view.addActionListener(e ->
            JOptionPane.showMessageDialog(f, model.viewEmployees(),
                "Employees", JOptionPane.INFORMATION_MESSAGE));

        change.addActionListener(e -> {
            JPasswordField oldP = new JPasswordField();
            JPasswordField newP = new JPasswordField();
            JPasswordField confirmP = new JPasswordField();

            Object[] fields = {
                "Old Password:", oldP,
                "New Password:", newP,
                "Confirm Password:", confirmP
            };

            int result = JOptionPane.showConfirmDialog(
                f, fields, "Change Password", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                boolean ok = model.changePassword(
                    new String(oldP.getPassword()),
                    new String(newP.getPassword()),
                    new String(confirmP.getPassword()));

                JOptionPane.showMessageDialog(f,
                    ok ? "Password changed successfully." :
                         "Invalid old password or passwords do not match.");
            }
        });

        logout.addActionListener(e -> {
            f.dispose();
            loginWindow();
        });

        exitApp.addActionListener(e -> System.exit(0));

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new EmployeeManagementPortal().loginWindow());
    }
}
