package lambda.inner.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * @Desc: 供给型接口只返回值，不入参
 * @Date: 10:17 上午 2022/3/18
 * @Author nebulaliao
 */
public class SupplierClass {
    /**
     * 供给型接口只返回值，不入参
     */
    @Test
    public void testSupplier() {
        List<Integer> result = getNumList(10, () -> (int) (Math.random() * 10));
        result.forEach(System.out::println);
    }

    private List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int supply = supplier.get();
            list.add(supply);
        }

        return list;
    }
}
