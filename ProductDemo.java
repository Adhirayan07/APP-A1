import java.util.Scanner;

abstract class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    void display() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;

        System.out.println("
Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Original Price: Rs." + price);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Price: Rs." + finalPrice);
    }
}

class Electronics extends Product {

    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {

    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {

    Books(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return price * 0.15;
    }
}

public class ProductDemo {
    public static void main(String[] args) {

        Product p1 = new Electronics(101, "Laptop", 60000);
        Product p2 = new Clothing(102, "Shirt", 2000);
        Product p3 = new Books(103, "Java Book", 1000);

        p1.display();
        p2.display();
        p3.display();
    }
}