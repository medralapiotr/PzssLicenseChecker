import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WebsiteCredentials Credentials = new WebsiteCredentials();

        System.out.println("Please enter Login:");
        Credentials.setLogin(scanner.nextLine());

        System.out.println("Please enter Password:");
        Credentials.setPassword(scanner.nextLine());

        LicenseStatus status = new LicenseStatus();
        status.fetchLicenseStatus(Credentials.getCredentials());

    }
}
