class EmergencyAlert extends Thread {
    public EmergencyAlert() {
        super("EmergencyAlert");
        setPriority(MAX_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
            System.out.println(getName() + " - Priority: " + getPriority() +
                " - Critical patient alert");
    }
}

class VitalMonitor extends Thread {
    public VitalMonitor() {
        super("VitalMonitor");
        setPriority(NORM_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
            System.out.println(getName() + " - Priority: " + getPriority() +
                " - Checking vital signs");
    }
}

class ReportGenerator extends Thread {
    public ReportGenerator() {
        super("ReportGenerator");
        setPriority(MIN_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
            System.out.println(getName() + " - Priority: " + getPriority() +
                " - Generating routine report");
    }
}

public class HospitalEmergencyMonitoring {
    public static void main(String[] args) {
        Thread t1 = new EmergencyAlert();
        Thread t2 = new VitalMonitor();
        Thread t3 = new ReportGenerator();

        System.out.println(t1.getName() + " Priority = " + t1.getPriority());
        System.out.println(t2.getName() + " Priority = " + t2.getPriority());
        System.out.println(t3.getName() + " Priority = " + t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }
}
