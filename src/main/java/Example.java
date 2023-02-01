import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class Example {
    public static void main(String args[]) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        URI firstWebSiteAddress = URI.create("https://github.com/sridevidoraraj/HttpClient");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(firstWebSiteAddress)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString());

            System.out.print(response.statusCode());
            System.out.print(response.body());
        } catch (Exception e) {
            System.out.println("We cannot access the site. Please, try later.");
        }

//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        URI fakePostService = URI.create("https://jsonplaceholder.typicode.com/posts");
//        String bookData = "{\"title\":\"The Invisible Man\", \"author\":\"H. G. Wells\"}";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(fakePostService)
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(bookData))
//                .build();
//
//        try {
//            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.statusCode());
//            System.out.println(response.body());
//        } catch (Exception e) {
//            System.out.println("We cannot send data. Please, try later.");
//        }

//        HttpClient client = HttpClient.newHttpClient();
//
//        var request = HttpRequest.newBuilder(URI.create("http://webcode.me"))
//                .method("HEAD", HttpRequest.BodyPublishers.noBody())
//                .build();
//
//        HttpResponse<Void> response = client.send(request,
//                HttpResponse.BodyHandlers.discarding());
//
//        HttpHeaders headers = response.headers();
//
//        headers.map().forEach((key, values) -> {
//            System.out.printf("%s: %s%n", key, values);
//        });

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://webcode.me"))
//                .GET()
//                .build();
//
//        var fileName = "D:\\Projects\\HttpClient\\demo\\src\\main\\resources\\index.html";
//
//        HttpResponse response = client.send(request,
//                HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));
//
//        System.out.println(response.statusCode());
    }
}
