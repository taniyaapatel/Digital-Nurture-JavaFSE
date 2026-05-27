
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Creating HTTP Client...");
            HttpClient hc = HttpClient.newHttpClient();


            System.out.println("Sending GET request to GitHub API...");
            HttpRequest hr = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> rp = hc.send(hr, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Status Code: " + rp.statusCode());
            System.out.println("Response Body (first 500 chars):");
            String b = rp.body();
            if (b.length() > 500) {
                System.out.println(b.substring(0, 500) + "...");
            } else {
                System.out.println(b);
            }
        } catch (Exception e) {
            System.out.println("HTTP request failed: " + e.getMessage());
        }
    }
}
