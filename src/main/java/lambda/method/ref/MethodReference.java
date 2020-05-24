package lambda.method.ref;

import anonymous.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * lambda 表达式的方法引用
 *
 * 主要有三种格式
 * 对象
 *  对象::实例方法名
 *
 * 静态方法
 *  类::静态方法名
 *
 *  类::实例方法名
 *
 *  注意：
 *      lambda 体中调用方法参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 */
public class MethodReference {


    /**
     * 对象::实例方法名
     */
    @Test
    public void testObjMethodRef(){
        //consumer
        Consumer<String> consumer0 = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> consumer1= ps::println;

        Consumer<String> consumer2 = System.out::println;

        consumer0.accept("consumer0");
        consumer1.accept("consumer1");
        consumer2.accept("consumer2");

        //supplier
        System.out.println();
        Employee emp = Employee.builder().age(10).name("brother chen").salary(999999.9).build();
        Supplier<String> supplier0 = () -> emp.getName();

        Supplier<String> supplier1 = emp::getName;

        System.out.println(supplier0.get());
        System.out.println(supplier1.get());
    }

    /**
     * 静态方法
     *  类::静态方法名
     */
    public void testStaticMethodRef(){
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = Lists.newArrayList(3,2,1,5);
        Collections.sort(list, comparator);
        list.forEach(System.out::println);

    }
    /**
     * 类::实例方法名
     * lambda 体中，第一个参数是实例方法的调用方，第二个参数是实例方法的入参，则可以使用 ClassName::method
     */
    public void testClassMethodRef(){
        BiPredicate<String, String> original0 = (x ,y)-> x.equalsIgnoreCase(y);
        BiPredicate<String, String> original1 = String::equalsIgnoreCase;
    }
}
