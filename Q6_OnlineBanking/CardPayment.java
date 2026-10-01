package Q6_OnlineBanking;

public class CardPayment implements Payment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}
