import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        double totalPrice = price * quantity;
        double discount;

        if (totalPrice >= 5000) {
            discount = totalPrice * 0.10;
        } else {
            discount = totalPrice * 0.05;
        }

        double finalPrice = totalPrice - discount;

        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.printf("Total Price: ₹%.2f%n", totalPrice);
        System.out.printf("Discount: ₹%.2f%n", discount);
        System.out.printf("Final Price: ₹%.2f%n%n", finalPrice);
    }
}

public class ProductBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Product " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            products[i] = new Product(id, name, price, quantity);
        }

        System.out.println("
--- Product Bill ---");

        for (Product p : products) {
            p.display();
        }

        sc.close();
    }
}
