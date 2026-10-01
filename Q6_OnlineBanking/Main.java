package Q6_OnlineBanking;

public class Main {
    public static void main(String[] args) {
        Account account;

        account = new SavingsAccount(101, "Adhirayan", 50000);
        account.displayDetails();

        account = new CurrentAccount(102, "Kumar", 75000);
        account.displayDetails();

        Payment upi = new UPIPayment();
        upi.pay(1500);
        ((SecurePayment) upi).verifyPayment();
        System.out.println("UPI is online transaction: " + (upi instanceof OnlineTransaction));

        Payment card = new CardPayment();
        card.pay(2500);
        System.out.println("Card is online transaction: " + (card instanceof OnlineTransaction));
    }
}
