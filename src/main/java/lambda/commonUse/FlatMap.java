package lambda.commonUse;

import com.google.common.collect.Lists;
import define_function_self.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map 是在一个流上对流的元素操作
 * flatMap 则是把这个流上的每个元素都转换成另一个流
 */
public class FlatMap {

    @Test
    public void testFlatMap(){
        //输入[1,2,3], [3,4] 变成 [[1, 3], [1, 4], [2, 3], [2, 4], [3, 3], [3, 4]]
        List<Integer> arr1 = Lists.newArrayList(1, 2, 3);
        List<Integer> arr2 = Lists.newArrayList(3, 4);

        //第一个如果用 map 会报错，因为它没法把一个元素转成另外一种流
        List<List<Integer>> result2 = arr1.stream()
                .flatMap(a1-> arr2.stream()
                        .map(a2->Lists.newArrayList(a1, a2))
        ).collect(Collectors.toList());
        //输出 [[1, 3], [1, 4], [2, 3], [2, 4], [3, 3], [3, 4]]
        System.out.println(result2);
    }
}
