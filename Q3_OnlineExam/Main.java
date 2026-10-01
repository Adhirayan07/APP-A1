package Q3_OnlineExam;

class ExamTask implements Runnable {
    private String activity;

    ExamTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + activity);
            try {
                Thread.sleep(activity.equals("Displaying remaining time") ? 1000 : activity.equals("Auto-saving answers") ? 1500 : 2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExamTask("Displaying remaining time"));
        Thread t2 = new Thread(new ExamTask("Auto-saving answers"));
        Thread t3 = new Thread(new ExamTask("Checking network connection"));

        t1.setName("Timer Thread");
        t2.setName("AutoSave Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
