package Q5_TrafficManagement;

class Junction extends Thread {
    private String status;
    private int delay;

    Junction(String name, String status, int delay) {
        setName(name);
        this.status = status;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: " + status);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread j1 = new Junction("Junction 1", "Heavy Traffic", 1000);
        Thread j2 = new Junction("Junction 2", "Moderate Traffic", 1500);
        Thread j3 = new Junction("Junction 3", "Low Traffic", 2000);

        j1.start();
        j2.start();
        j3.start();
    }
}
