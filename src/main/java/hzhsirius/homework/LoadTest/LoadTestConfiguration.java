package hzhsirius.homework.LoadTest;

import lombok.Getter;

/**
 * 性能测试配置类
 *
 * @author AlbertSirius
 * @since 2020/7/22
 */

@Getter
public class LoadTestConfiguration {

    private String uri;
    private int concurrentNum;
    private int requestNum;
    private int percent;

    public LoadTestConfiguration (String[] args) {
        if(args.length < 3) throw new IllegalArgumentException("At least 3 arguments!");
        this.uri = args[0];
        this.concurrentNum = Integer.valueOf(args[1]);
        this.requestNum = Integer.valueOf(args[2]);
        this.percent = 0;
        if(args.length > 3) this.percent = Integer.valueOf(args[3]);
    }
}
