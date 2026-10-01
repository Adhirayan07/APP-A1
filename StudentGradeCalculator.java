import javax.swing.*;
import java.awt.*;

class GradeModel {
    String name;
    int m1, m2, m3;

    void setData(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    int total() { return m1 + m2 + m3; }

    double average() { return total() / 3.0; }

    String grade() {
        double a = average();
        if (a >= 90) return "A";
        if (a >= 75) return "B";
        if (a >= 60) return "C";
        if (a >= 50) return "D";
        return "F";
    }
}

class GradeView extends JFrame {
    JTextField name = new JTextField();
    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();
    JTextField m3 = new JTextField();
    JButton calculate = new JButton("Calculate Result");

    GradeView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Student Name")); add(name);
        add(new JLabel("Subject 1")); add(m1);
        add(new JLabel("Subject 2")); add(m2);
        add(new JLabel("Subject 3")); add(m3);
        add(new JLabel()); add(calculate);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class GradeController {
    GradeModel model;
    GradeView view;

    GradeController(GradeModel model, GradeView view) {
        this.model = model;
        this.view = view;
        view.calculate.addActionListener(e -> calculate());
    }

    void calculate() {
        try {
            model.setData(
                view.name.getText(),
                Integer.parseInt(view.m1.getText()),
                Integer.parseInt(view.m2.getText()),
                Integer.parseInt(view.m3.getText())
            );

            JOptionPane.showMessageDialog(view,
                "Name: " + model.name +
                "\nTotal: " + model.total() +
                "\nAverage: " + String.format("%.2f", model.average()) +
                "\nGrade: " + model.grade());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Enter valid marks.");
        }
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new GradeController(new GradeModel(), new GradeView()));
    }
}
