package lambda.grammer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 表达式左侧：入参
 * 表示右侧：函数执行
 * <p>
 * 语法格式1：无参，无返回
 * 语法格式2：有一个参数，无返回值
 * 语法格式3：有两个参数，lambda 体中有多条语句
 * 语法格式4：如果只有一条语句，return 和大阔号都可以省略
 * 语法格式5：lambda 表达式的类型可以不写，JVM 编译器通过上下文推断
 * <p>
 * lambda 表示需要函数式接口的支持
 * 函数式接口，接口中只有一个抽象方法的接口称为函数式接口，可以使用@FunctionalInterface 检查是否是函数式接口
 */
public class TestLambdaGrammer {
    @Test
    public void test1() {
        System.out.println("无参，无返回");
        Runnable runnable = () -> System.out.println("hello world");
        runnable.run();
    }

    @Test
    public void test2() {
        System.out.println("有一个参数，无返回值");
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("我是 accept");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式语句");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void tets4() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    @Test
    public void tets5() {
        System.out.println("根据目标推测传参的入参类型");
        List<String> list = new ArrayList<>();
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test6() {
        System.out.println("函数式编程");
        int square = operation(10, (num) -> num * num);
        System.out.println(square);
        int add = operation(10, (num) -> num + 100);
        System.out.println(add);
    }

    private Integer operation(int num, MyFunction myFunction){
        return myFunction.getValue(num);
    }
}
