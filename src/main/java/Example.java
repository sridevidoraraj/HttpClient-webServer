import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.LogManager;

public class Example {
    static ColorLogger colorLogger = new ColorLogger();
    static {
        InputStream stream = Example.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        URI host = URI.create("http://localhost:8085/index.html");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(host)
                .GET()
                .build();

        var fileName = "D:/Projects/HttpClient/demo/src/main/resources/index.html";



            HttpResponse response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));
            colorLogger.logInfo("Connected To : " + host);

            colorLogger.logInfo("StatusCode : " + response.statusCode());

            colorLogger.logInfo("Headers : " +response.headers());

            colorLogger.logInfo("Request : " +response.request());


    }
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

