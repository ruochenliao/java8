package lambda.inner.function;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * @Desc: 断言型接口，给一个入参，返回 boolean
 * @Date: 10:08 上午 2022/3/18
 * @Author nebulaliao
 */
public class PredicateClass {
    @Test
    public void testPredicate() {
        List<String> list = Lists.newArrayList("hello", "world", "my", "name", "is");
        List<String> filterList = filterList(list, (x) -> x.length() > 3);
        filterList.forEach(System.out::println);
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
