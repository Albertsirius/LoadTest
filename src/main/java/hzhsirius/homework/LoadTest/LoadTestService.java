package hzhsirius.homework.LoadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>性能测试主体类
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */
public class LoadTestService {

    private LoadTestConfiguration loadTestConfiguration;
    private Statistic statistic;
    private CountDownLatch countDownLatch;
    private Task task;

    public LoadTestService(LoadTestConfiguration loadTestConfiguration) {
        this.loadTestConfiguration = loadTestConfiguration;
        this.statistic = new StatisticImpl(loadTestConfiguration.getRequestNum());
        this.task = new HttpRequestTask(loadTestConfiguration.getUri());
        countDownLatch = new CountDownLatch(loadTestConfiguration.getRequestNum());
    }

    public void loadTest() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(loadTestConfiguration.getConcurrentNum());
        for (int count = 0; count < loadTestConfiguration.getRequestNum(); count++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    task.doTask();
                    statistic.collectResult(System.currentTimeMillis() - start);
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        executor.shutdown();
        printResult(statistic);
    }

    private void printResult(Statistic statistic) {
        System.out.println("The Average request time: " + statistic.getAverage());
        System.out.println("The 95% request time: "+ statistic.getPercent(loadTestConfiguration.getPercent()));
    }


}
