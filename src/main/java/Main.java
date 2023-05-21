import lombok.Data;

import java.net.http.HttpClient;

@Data
public class Main {
    public static final HttpClient SERVER = HttpClient.newHttpClient();

    public static void main(String[] args) {
        HttpImageStatusCli.askStatus();
    }
}
