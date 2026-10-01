package Q2_HospitalManagement;

import Q2_HospitalManagement.doctor.Doctor;
import Q2_HospitalManagement.patient.Patient;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(1, "Dr. Ravi", "Cardiology", 800);
        Doctor d2 = new Doctor(2, "Dr. Priya", "Dermatology", 600);

        Patient p1 = new Patient(101, "Arun", "Heart Disease", 45);
        Patient p2 = new Patient(102, "Meena", "Skin Allergy", 30);
        Patient p3 = new Patient(103, "Kiran", "Heart Disease", 50);

        d1.display();
        p1.display();
        System.out.println("Treating Doctor: " + d1.getName());
        p3.display();
        System.out.println("Treating Doctor: " + d1.getName());

        d2.display();
        p2.display();
        System.out.println("Treating Doctor: " + d2.getName());

        System.out.println("Total fee collected by " + d1.getName() + ": ₹" + (2 * d1.getConsultationFee()));
        System.out.println("Total fee collected by " + d2.getName() + ": ₹" + d2.getConsultationFee());
    }
}
