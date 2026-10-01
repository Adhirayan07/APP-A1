package Q3_Security;

public class BankingApplication implements AdvancedSecurity {
    public void login() {
        System.out.println("Login successful");
    }

    public void logout() {
        System.out.println("Logout successful");
    }

    public void fingerprintAuthentication() {
        System.out.println("Fingerprint authentication successful");
    }

    public void faceAuthentication() {
        System.out.println("Face recognition authentication successful");
    }
}
