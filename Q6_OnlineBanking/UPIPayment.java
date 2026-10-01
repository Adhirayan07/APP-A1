package Q6_OnlineBanking;

public class UPIPayment implements SecurePayment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }

    public void verifyPayment() {
        System.out.println("UPI payment verified");
    }
}
