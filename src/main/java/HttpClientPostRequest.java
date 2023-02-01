import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class HttpClientPostRequest {
    public static void main(String[] args) throws IOException, InterruptedException {

//        var values = new HashMap<String, String>() {{
//            put("name", "John Doe");
//            put ("occupation", "software");
//        }};
//
//        var objectMapper = new ObjectMapper();
//        String requestBody = objectMapper
//                .writeValueAsString(values);
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://httpbin.org/post"))
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.statusCode());
//
//        System.out.println(response.body());

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS).build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/redirect/3"))
                .GET()
                .build();

        HttpResponse response = client.send(request,
                HttpResponse.BodyHandlers.discarding());

        System.out.println(response.statusCode());
    }
}
