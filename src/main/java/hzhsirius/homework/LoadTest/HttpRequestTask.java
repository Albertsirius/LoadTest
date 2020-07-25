package hzhsirius.homework.LoadTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * <p>
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */
public class HttpRequestTask implements Task{


    private final String httpSchema = "http://";
    private String uri;

    public HttpRequestTask(String uri) {
        this.uri = uri;
    }

    @Override
    public void doTask() {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(httpSchema + uri)).header("Cache-Control","no-cache,no-store").build();
            HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
