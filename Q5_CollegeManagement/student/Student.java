package Q5_CollegeManagement.student;

public class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void display() {
        System.out.println("Student Roll No: " + rollNo);
        System.out.println("Student Name: " + name);
    }
}
