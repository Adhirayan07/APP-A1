package Q2_HospitalManagement.doctor;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }

    public void display() {
        System.out.println("Doctor: " + name + " | ID: " + doctorId + " | Specialization: " + specialization + " | Fee: ₹" + consultationFee);
    }
}
