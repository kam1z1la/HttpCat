import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(HttpStatusChecker.getStatusImage(code)))
                .GET()
                .build();
        HttpResponse<InputStream> response = Main.SERVER.send(request, HttpResponse.BodyHandlers.ofInputStream());
        try (OutputStream outputStream = new FileOutputStream("src/main/resources/pictures/cuteCat.jpg")) {
            outputStream.write(response.body().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        HttpResponse<Path> response = Main.SERVER.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("src/main/resources/pictures/cuteCat.jpg")));
//        System.out.println(response.headers());
    }
}
