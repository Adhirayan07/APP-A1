import javax.swing.*;
import java.awt.*;

class ServiceModel {
    int calculate(boolean general, boolean oil, boolean brake, boolean battery) {
        int total = 0;
        if (general) total += 1000;
        if (oil) total += 800;
        if (brake) total += 1200;
        if (battery) total += 500;
        return total;
    }
}

class ServiceView extends JFrame {
    JTextField regNo = new JTextField();
    JRadioButton twoWheeler = new JRadioButton("Two Wheeler");
    JRadioButton car = new JRadioButton("Car", true);
    JCheckBox general = new JCheckBox("General Service - Rs.1000");
    JCheckBox oil = new JCheckBox("Oil Change - Rs.800");
    JCheckBox brake = new JCheckBox("Brake Service - Rs.1200");
    JCheckBox battery = new JCheckBox("Battery Check - Rs.500");
    JButton calculate = new JButton("Calculate Cost");

    ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(500, 350);
        setLayout(new GridLayout(8, 2, 8, 8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(twoWheeler);
        bg.add(car);

        add(new JLabel("Registration Number")); add(regNo);
        add(new JLabel("Vehicle Type")); add(twoWheeler);
        add(new JLabel("")); add(car);
        add(general); add(oil);
        add(brake); add(battery);
        add(new JLabel("")); add(calculate);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class ServiceController {
    ServiceModel model;
    ServiceView view;

    ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;
        view.calculate.addActionListener(e -> calculate());
    }

    void calculate() {
        int total = model.calculate(
            view.general.isSelected(),
            view.oil.isSelected(),
            view.brake.isSelected(),
            view.battery.isSelected());

        JOptionPane.showMessageDialog(view,
            "Registration No: " + view.regNo.getText() +
            "\nVehicle Type: " +
            (view.car.isSelected() ? "Car" : "Two Wheeler") +
            "\nTotal Service Cost: Rs." + total);
    }
}

public class VehicleServiceCostEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new ServiceController(new ServiceModel(), new ServiceView()));
    }
}
