import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagement extends JFrame {
    JList<String> courseList;
    DefaultTableModel model;
    JTable table;

    StudentCourseManagement() {
        setTitle("Student Course Management");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        courseList = new JList<>(new String[]{
            "Java", "Python", "Data Structures", "DBMS", "Computer Networks"
        });

        model = new DefaultTableModel(
            new String[]{"Student Name", "Selected Course", "Status"}, 0);
        table = new JTable(model);

        JTextField nameField = new JTextField();
        JButton add = new JButton("Add Registration");
        JButton remove = new JButton("Remove Registration");

        JPanel top = new JPanel(new GridLayout(1, 2));
        top.add(new JLabel("Student Name"));
        top.add(nameField);

        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(remove);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(courseList), BorderLayout.WEST);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        add.addActionListener(e -> {
            String name = nameField.getText().trim();
            String course = courseList.getSelectedValue();

            if (name.isEmpty() || course == null) {
                JOptionPane.showMessageDialog(this, "Enter name and select a course.");
                return;
            }

            model.addRow(new Object[]{name, course, "Enrolled"});
            nameField.setText("");
        });

        remove.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row >= 0)
                model.removeRow(row);
            else
                JOptionPane.showMessageDialog(this, "Select a registration to remove.");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentCourseManagement();
    }
}
