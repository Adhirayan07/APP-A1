package Q1_CollegeManagement.course;

public class Course {
    private String code;
    private String name;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void display() {
        System.out.println("Course Code: " + code);
        System.out.println("Course Name: " + name);
    }
}
