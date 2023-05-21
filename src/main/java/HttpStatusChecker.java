import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(String.format("https://http.cat/%s",code)))
                .GET()
                .build();
        HttpResponse<String> response = Main.SERVER.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 404) {
            return String.valueOf(response.uri());
        } else {
            throw new HttpRetryException("Not Found", response.statusCode());
        }
    }
}
