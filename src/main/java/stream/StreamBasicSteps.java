package stream;

import define_function_self.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流(stream)
 * 是数据渠道，用于操作数据源（集合，数组等）所生成的元素序列
 * 集合讲的是数据，流讲的是计算
 *
 * 三个步骤
 * 1、创建 stream
 * 2、中间操作
 * 3、终止操作: 终止操作不执行的话，中间操作不会被执行掉
 *
 * 注意
 * 1、stream 不会存储元素
 * 2、stream 不会改变原对象。相反，它会返回一个持有结果的新 Stream
 * 3、stream 操作是延时的，也就是说除非流水线出发终止操作，否则中间操作不会执行任何处理
 */
public class StreamBasicSteps {

    List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).salary(1000.0).build(),
                Employee.builder().name("张三").age(20).salary(10000.0).build(),
                Employee.builder().name("李四").age(30).salary(100000.0).build(),
                Employee.builder().name("晨哥").age(40).salary(10000000.0).build(),
                Employee.builder().name("晨哥").age(40).salary(10000000.0).build()
    );

    /**
     * 创建流
     */
    @Test
    public void createStream(){
        //1、可以通过 collection 系列提供 stream 或者 parallelStream
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2、通过 Arrays 静态方法 stream 获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        //3、通过 Stream 类中静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "c");

        //4、创建无限流
        //利用 Stream.iterate 创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, x->x+2);
        //迭代10次, 打印 2，4，6，8，10 ... 无限循环
        stream4.limit(10).forEach(System.out::println);
        //无限迭代, 打印 2，4，6，8，10 ... 无限循环
        stream4.forEach(System.out::println);
        //利用 Stream.generate() 创建无限流，流水线创建 5 个
        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }

    /**
     * stream 中间操作，内部迭代
     *
     */
    @Test
    public void streamMiddleOperation(){
        /**
         * 1、筛选与切片
         *  filter: stream 中过滤某些元素
         *  limit: 截断流
         *  skip(n): 跳过元素，返回一个
         */
        //中间操作：过滤，不会执行任何操作，直到终止操作的时候，才会执行全部操作，这种被称为惰性求职
        Stream<Employee> filtedList = employeeList.stream().filter((e) -> {
            System.out.println("hello world");
            return e.getAge() > 35;
        });
        //终止操作：输出
        filtedList.forEach(System.out::println);

    }
    /**
     * stream 中间操作，外部迭代
     */
    @Test
    public void streamMidOperationOuterIteration(){
        Iterator<Employee> it = employeeList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
     * stream.limit
     */
    @Test
    public void streamLimitOperation(){
        employeeList.stream()
                .filter((e)->e.getSalary()>5000)
                .limit(2)
                .forEach(System.out::println);
    }

    /**
     * stream.skip(n) 跳过前 n 个
     */
    @Test
    public void streamSkip(){
        //过滤出来后，过滤前 2 个
        employeeList.stream()
                .filter((e)->e.getSalary()>5000)
                .skip(2)
                .forEach(System.out::println);
    }

    /**
     * distinct 根据元素的 hashCode 和 equals 来确保一样
     */
    @Test
    public void streamDistinct() {
        employeeList.stream()
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 终止操作
     */

}
