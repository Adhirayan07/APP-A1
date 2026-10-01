package Q6_OnlineBanking;

public class SavingsAccount extends Account {
    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account: " + accountNumber + ", " + holderName + ", Balance: ₹" + balance);
    }
}
