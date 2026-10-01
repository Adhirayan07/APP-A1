import java.util.Scanner;

class Patient {
    String name;
    double consultationFee;

    Patient(String name, double consultationFee) {
        this.name = name;
        this.consultationFee = consultationFee;
    }

    double calculateFinalAmount(double fee) {
        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        return fee - discount;
    }

    void display() {
        double finalAmount = calculateFinalAmount(consultationFee);
        double discount = consultationFee - finalAmount;

        System.out.println("Patient Name: " + name);
        System.out.printf("Original Consultation Fee: ₹%.2f%n", consultationFee);
        System.out.printf("Discount: ₹%.2f%n", discount);
        System.out.printf("Final Amount: ₹%.2f%n%n", finalAmount);
    }
}

public class HospitalBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Patient " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();

            patients[i] = new Patient(name, fee);
        }

        System.out.println("
--- Consultation Bill ---");

        for (Patient p : patients) {
            p.display();
        }

        sc.close();
    }
}
