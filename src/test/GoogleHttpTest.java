
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

public class GoogleHttpTest {

    public static void main(String[] args) throws Exception {

        NetHttpTransport transport = new NetHttpTransport();

        HttpRequestFactory factory =
                transport.createRequestFactory();

        HttpRequest request = factory.buildRequest(
                "GET",
                new GenericUrl(
                        "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com"
                ),
                null
        );

        HttpResponse response = request.execute();

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Content-Type: " +
                response.getHeaders().getContentType());

        System.out.println("Body: " + response.parseAsString());

        response.disconnect();
    }
}
