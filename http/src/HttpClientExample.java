package http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {
    public static void main(String[] args) {
        //building request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://www.example.com/"))
            .GET()//used by default if we don't specify
            .build();
        //creating response body handler
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        //sending request and receiving response via HttpClient
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, bodyHandler);
        future.thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
    }
}
