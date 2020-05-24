package lambda.grammer;

import org.junit.Test;

/**
 * 申明一个带两个泛型的函数式接口，泛型类型为 <T, R> T 为参数, R 为返回值
 * 计算两个long 类型参数的和, 再算两个参数的积
 */
public class GenericFunction {

    @Test
    public void testGenericFunction(){
        Long addResult = operation(1L, 3L, (l1, l2) -> l1 + l2);
        Long multiResult = operation(1L, 3L, (l1, l2) -> l1 * l2);
        System.out.println(addResult);
        System.out.println(multiResult);
    }

    public Long operation(Long l1, Long l2, MyGenericFunction<Long, Long> myGenericFunction){
       return myGenericFunction.calculate(l1, l2);
    }
}
