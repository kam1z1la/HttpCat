import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() {
        Scanner scannerStatus = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");
        if (scannerStatus.hasNextInt()) {
            int statusCode = scannerStatus.nextInt();
            try (scannerStatus) {
                HttpStatusImageDownloader.downloadStatusImage(statusCode);
                System.out.println("Image uploaded to resources folder");
            } catch (URISyntaxException | IOException | InterruptedException e) {
                System.out.printf("There is not image for HTTP status %d", statusCode);
            }
        } else {
            System.out.println("Please enter valid number");
            askStatus();
        }
    }
}
