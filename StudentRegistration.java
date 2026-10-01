import javax.swing.*;
import java.awt.*;

public class StudentRegistration extends JFrame {
    JTextField nameField = new JTextField();
    JTextField regField = new JTextField();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JComboBox<String> deptBox = new JComboBox<>(new String[]{"CSE", "ECE", "EEE", "MECH"});

    StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        add(new JLabel("Student Name")); add(nameField);
        add(new JLabel("Register Number")); add(regField);
        add(new JLabel("Gender"));

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        add(new JLabel("Department")); add(deptBox);

        JButton submit = new JButton("Submit");
        add(new JLabel()); add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Not selected";

            JOptionPane.showMessageDialog(this,
                "Name: " + nameField.getText() +
                "\nRegister No: " + regField.getText() +
                "\nGender: " + gender +
                "\nDepartment: " + deptBox.getSelectedItem(),
                "Registration Details",
                JOptionPane.INFORMATION_MESSAGE);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
