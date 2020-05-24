package lambda.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * java 8 并行流
 *
 * 性能会提高
 * 底层用的 fork join
 */
public class Parellel {

    @Test
    public void parellel(){
        Instant start = Instant.now();
        long result = LongStream.rangeClosed(0, 1000000000L)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("消耗时间: " + Duration.between(start, end).toMillis());
    }
}
