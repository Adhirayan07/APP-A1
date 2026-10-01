package Q4_Documents;

public class Main {
    public static void main(String[] args) {
        Object[] documents = {
            new Report("Employee Report"),
            new Invoice("Sales Invoice")
        };

        for (Object document : documents) {
            if (document instanceof Confidential)
                System.out.println("Confidential document");
            else
                System.out.println("Non-confidential document");
        }
    }
}
