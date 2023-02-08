import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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



