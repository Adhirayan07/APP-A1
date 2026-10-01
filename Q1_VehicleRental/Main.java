package Q1_VehicleRental;

public class Main {
    public static void main(String[] args) {
        Vehicle v;

        v = new Car("TN01AB1234", "Toyota", 120, 4);
        v.displayDetails();

        v = new Bike("TN02CD5678", "Yamaha", 100, true);
        v.displayDetails();
    }
}
