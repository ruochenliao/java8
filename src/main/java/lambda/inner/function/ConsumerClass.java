package lambda.inner.function;

import java.util.function.Consumer;
import org.junit.Test;

/**
 * @Desc: 消费型接口只入参，不出参
 *
 * @Date: 10:16 上午 2022/3/18
 * @Author nebulaliao
 */
public class ConsumerClass {
    /**
     * 消费型接口只入参，不出参
     */
    @Test
    public void testConsumer() {
        happy(10000.0, (x) -> System.out.println("晨哥消费: " + x));
    }

    private void happy(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
