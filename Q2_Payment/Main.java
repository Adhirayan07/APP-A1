package Q2_Payment;

public class Main {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.pay(1500);

        p = new UPIPayment();
        p.pay(800);

        p = new NetBankingPayment();
        p.pay(2500);
    }
}
