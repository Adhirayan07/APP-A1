package Q1_VehicleRental;

public class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike: " + vehicleNumber + ", " + brand + ", " + speed + " km/h, Has Gear: " + hasGear);
    }
}
