package lambda.inner.function;

import java.util.function.Function;
import org.junit.Test;

/**
 * @Desc: 函数型接口，有一个入参，有一个出参
 *
 * @Date: 10:18 上午 2022/3/18
 * @Author nebulaliao
 */
public class FunctionClass {
    /**
     * 函数型接口，有一个入参，有一个出参
     */
    @Test
    public void testFunction() {
        String processResult = processStr("hello world", (str) -> str.toUpperCase());
        String cutResult = processStr("hello world", (str) -> str.substring(1, 3));
        System.out.println(processResult);
        System.out.println(cutResult);
    }

    private String processStr(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
