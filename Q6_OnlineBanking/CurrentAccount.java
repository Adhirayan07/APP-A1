package Q6_OnlineBanking;

public class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void displayDetails() {
        System.out.println("Current Account: " + accountNumber + ", " + holderName + ", Balance: ₹" + balance);
    }
}
