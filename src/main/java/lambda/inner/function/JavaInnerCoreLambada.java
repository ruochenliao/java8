package lambda.inner.function;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * JAVA 8 内置的4 大函数式接口
 *
 * 消费型接口
 * Consumer<T>
 * void accept(T t);
 *
 * 供给型接口
 * Supplier<T>
 * T get();
 *
 * 函数型接口
 * Function<T, R>
 * R apply(T t);
 *
 * 断言型接口
 * Predicate<T>
 * boolean test(T t);
 *
 * 除此之外还有一些子接口
 * BiFunction<T, U, R> 入参是 T, U 返回值是 R
 *
 */
public class JavaInnerCoreLambada {

    /**
     * 消费型接口只入参，不出参
     */
    @Test
    public void testConsumer() {
        happy(10000.0, (x) -> System.out.println("晨哥消费: " + x));
    }

    /**
     * 供给型接口只返回值，不入参
     */
    @Test
    public void testSupplier() {
        List<Integer> result = getNumList(10, () -> (int) (Math.random() * 10));
        result.forEach(System.out::println);
    }

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

    /**
     * 断言型接口，给一个入参，返回 boolean
     */
    @Test
    public void testPredicate() {
        List<String> list = Lists.newArrayList("hello", "world", "my", "name", "is");
        List<String> filterList = filterList(list, (x) -> x.length() > 3);
        filterList.forEach(System.out::println);
    }

    private List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int supply = supplier.get();
            list.add(supply);
        }

        return list;
    }

    private void happy(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    private String processStr(String str, Function<String, String> function) {
        return function.apply(str);
    }

    private List<String> filterList(List<String> list, Predicate<String> predicate) {

        List<String> filteredList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                filteredList.add(str);
            }
        }

        return filteredList;
    }

}
