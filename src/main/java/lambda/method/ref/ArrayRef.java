package lambda.method.ref;

import org.junit.Test;

import java.util.function.Function;

/**
 * 数组引用
 * Type::new
 */
public class ArrayRef {

    @Test
    public void testArrayRef() {
        Function<Integer, String[]> function0 = (x) -> new String[x];
        Function<Integer, String[]> function1 = String[]::new;

        String[] arr0 = function0.apply(20);
        String[] arr1 = function1.apply(20);

        System.out.println(arr0.length);
        System.out.println(arr1.length);
    }
}
