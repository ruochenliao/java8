package lambda.commonUse;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

/**
 * 逻辑运算使用 Function 的 andThen 和 compose 两个接口
 */
public class FunctionAndThen {

    /**
     * andThen 是先后运算
     */
    @Test
    public void testFunctionAndThen(){

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int andThenResult = h.apply(1);
        // andThen g(f(x));
        Assert.assertEquals(andThenResult, 4);

        // compose g(f(x));
        Function<Integer, Integer> c = g.compose(f);
        int composeResult = c.apply(1);
        Assert.assertEquals(composeResult, 4);
    }
}
