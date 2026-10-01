package Q1_CollegeManagement;

import Q1_CollegeManagement.student.Student;
import Q1_CollegeManagement.course.Course;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(101, "Adhirayan");
        Course c = new Course("CSE101", "Computer Science");

        s.display();
        c.display();
    }
}
