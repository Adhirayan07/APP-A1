import java.sql.*;
import java.util.Scanner;

public class LibraryJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    static final String USER = "root";
    static final String PASSWORD = "password";

    static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insertBook(Scanner sc) throws SQLException {
        System.out.print("Book ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO Book(BookID,Title,Author,Price,Availability) VALUES(?,?,?,?,?)";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            System.out.println("Book inserted.");
        }
    }

    static void searchBook(Scanner sc) throws SQLException {
        System.out.print("Book ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Book WHERE BookID=?";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("BookID"));
                    System.out.println("Title: " + rs.getString("Title"));
                    System.out.println("Author: " + rs.getString("Author"));
                    System.out.println("Price: " + rs.getDouble("Price"));
                    System.out.println("Available: " + rs.getBoolean("Availability"));
                } else {
                    System.out.println("Book not found.");
                }
            }
        }
    }

    static void showAvailable() throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability=true";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("BookID") + " | " +
                    rs.getString("Title") + " | " +
                    rs.getString("Author") + " | " +
                    rs.getDouble("Price"));
        }
    }

    static void issueBook(Scanner sc) throws SQLException {
        System.out.print("Book ID to issue: ");
        int id = sc.nextInt();

        String sql = "UPDATE Book SET Availability=false WHERE BookID=?";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate() > 0 ?
                "Book availability updated." : "Book not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert 2.Search 3.Available Books 4.Issue Book 5.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            try {
                if (ch == 1) insertBook(sc);
                else if (ch == 2) searchBook(sc);
                else if (ch == 3) showAvailable();
                else if (ch == 4) issueBook(sc);
                else break;
            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
