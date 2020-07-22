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
 * @since 2020/7/21
 */
public class LoadTestDemo {
    public static void main(String[] args) throws InterruptedException {
        LoadTestConfiguration configuration = new LoadTestConfiguration(args);
        LoadTestService loadTestService = new LoadTestService(configuration);
        loadTestService.loadTest();
    }


}
