package hzhsirius.homework.LoadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/**
 *
 * <p>
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */
public class StatisticImpl implements Statistic{

    private int requestNum;
    private int percent;
    private List<Long> resultList;

    public StatisticImpl(int requestNum, int percent ){
        this.requestNum = requestNum;
        this.percent = percent;
        resultList = new ArrayList<>(requestNum);
    }

    @Override
    public void collectResult(long result) {
        synchronized (this) {
            resultList.add(result);
        }
    }

    @Override
    public long getAverage() {
        long sum = 0L;
        for(long element : resultList) sum += element;
        return sum / requestNum;
    }

    @Override
    public long getPercent() {
        Collections.sort(resultList);
        return resultList.get(requestNum * percent / 100);
    }

    @Override
    public void printEach() {
        resultList.forEach( s -> System.out.println(s));
    }

}
