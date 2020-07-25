package hzhsirius.homework.LoadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * <p>
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */
public class StatisticsImpl implements Statistics {

    private int requestNum;
    private List<Long> resultList;

    public StatisticsImpl(int requestNum){
        this.requestNum = requestNum;
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
    public long getPercent(int percent) {
        Collections.sort(resultList);
        return resultList.get(requestNum * percent / 100);
    }


}
