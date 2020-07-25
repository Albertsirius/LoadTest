package hzhsirius.homework.LoadTest;

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
