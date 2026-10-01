import java.sql.*;
import java.util.Scanner;

public class ProductJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/storedb";
    static final String USER = "root";
    static final String PASSWORD = "password";

    static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insert(Scanner sc) throws SQLException {
        System.out.print("Product ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Product Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        String sql = "INSERT INTO Product(ProductID,ProductName,Price,Quantity) VALUES(?,?,?,?)";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, qty);
            ps.executeUpdate();
            System.out.println("Product inserted.");
        }
    }

    static void retrieve(Scanner sc) throws SQLException {
        System.out.print("Product ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM Product WHERE ProductID=?";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    System.out.println(rs.getInt("ProductID") + " | " +
                        rs.getString("ProductName") + " | " +
                        rs.getDouble("Price") + " | " +
                        rs.getInt("Quantity"));
                else
                    System.out.println("Product not found.");
            }
        }
    }

    static void updateQuantity(Scanner sc) throws SQLException {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        System.out.print("New Quantity: ");
        int qty = sc.nextInt();

        String sql = "UPDATE Product SET Quantity=? WHERE ProductID=?";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, id);
            System.out.println(ps.executeUpdate() > 0 ?
                "Quantity updated." : "Product not found.");
        }
    }

    static void lowStock() throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("ProductID") + " | " +
                    rs.getString("ProductName") + " | Qty: " +
                    rs.getInt("Quantity"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert 2.Retrieve 3.Update Quantity 4.Low Stock 5.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            try {
                if (ch == 1) insert(sc);
                else if (ch == 2) retrieve(sc);
                else if (ch == 3) updateQuantity(sc);
                else if (ch == 4) lowStock();
                else break;
            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
