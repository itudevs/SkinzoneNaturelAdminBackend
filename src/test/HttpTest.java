import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpTest {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com"
                ))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status: " + response.statusCode());
        System.out.println("Headers: " + response.headers().map());
        System.out.println("Body: " + response.body());
    }
}
