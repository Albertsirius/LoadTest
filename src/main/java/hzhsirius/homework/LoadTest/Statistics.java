package hzhsirius.homework.LoadTest;

/**
 * 收集和统计结果接口
 * <p>
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */
public interface Statistics {

    void collectResult(long result);

    long getAverage();

    long getPercent(int percent);

}
