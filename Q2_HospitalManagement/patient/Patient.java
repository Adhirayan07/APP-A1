package Q2_HospitalManagement.patient;

public class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getDisease() { return disease; }
    public int getAge() { return age; }

    public void display() {
        System.out.println("Patient: " + name + " | ID: " + patientId + " | Disease: " + disease + " | Age: " + age);
    }
}
