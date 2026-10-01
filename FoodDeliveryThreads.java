class DeliveryTask extends Thread {
    private String activity;

    DeliveryTask(String name, int priority, String activity) {
        super(name);
        setPriority(priority);
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Priority: " + getPriority() + " - " + activity);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class FoodDeliveryThreads {
    public static void main(String[] args) {
        Thread t1 = new DeliveryTask("OrderProcessing", 10, "Processing customer orders");
        Thread t2 = new DeliveryTask("DeliveryTracking", 5, "Tracking delivery location");
        Thread t3 = new DeliveryTask("Notification", 1, "Sending order-status notification");

        t1.start();
        t2.start();
        t3.start();
    }
}
