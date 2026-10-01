import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/collegedb";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        String sql = "SELECT * FROM CourseRegistration WHERE CourseCode=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, code);

            try (ResultSet rs = ps.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    System.out.println(
                        "Student ID: " + rs.getInt("StudentID") +
                        " | Name: " + rs.getString("StudentName") +
                        " | Course Code: " + rs.getString("CourseCode") +
                        " | Course Name: " + rs.getString("CourseName") +
                        " | Semester: " + rs.getString("Semester")
                    );
                }

                if (!found)
                    System.out.println("No students registered for " + code);
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
