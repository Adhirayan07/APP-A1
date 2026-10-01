package Q3_Security;

public class Main {
    public static void main(String[] args) {
        AdvancedSecurity security = new BankingApplication();
        security.login();
        security.fingerprintAuthentication();
        security.faceAuthentication();
        security.logout();
    }
}
