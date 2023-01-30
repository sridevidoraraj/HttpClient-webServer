import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Example {
    public static void main(String args[]){
        HttpClient httpClient = HttpClient.newHttpClient();

        URI firstWebSiteAddress = URI.create("http://info.cern.ch/hypertext/WWW/TheProject.html");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(firstWebSiteAddress)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("We cannot access the site. Please, try later.");
        }
    }
}
