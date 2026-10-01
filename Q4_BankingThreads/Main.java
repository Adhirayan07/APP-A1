package Q4_BankingThreads;

class BankTask implements Runnable {
    private String activity;
    private int delay;

    BankTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + activity + " - Count: " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BankTask("Transaction processing", 800));
        Thread t2 = new Thread(new BankTask("Balance updating", 1200));
        Thread t3 = new Thread(new BankTask("SMS notification", 1600));

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
