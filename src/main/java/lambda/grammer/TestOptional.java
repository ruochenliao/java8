package lambda.grammer;

import anonymous.Employee;
import org.junit.Test;

import java.time.Instant;
import java.util.Optional;

import static anonymous.Employee.Status.FREE;

/**
 * Optional 容器类常用方法
 * Optional.of(T t) 创建一个 Optional 实例
 * Optional.empty() 创建一个空 Optional
 * Optional.ofNullable(T t) 若 t 不为 null 创建 Optional 实例，否则创建空实例
 * isPresent 是否包含值
 * orElse(T t) 如果包含对象则返回该值，不行就返回 t
 * orElseGet(Supplier s) 如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f) 如果有值对其处理，并返回处理后的 Optional, 否则返回 Optional.empty()
 * flapMap(Function mapper) 与 mapper 类似， 要求必须返回 Optional
 */
public class TestOptional {

    private static final Employee employee = Employee.builder().age(16).name("晨哥").status(FREE).build();
    /**
     * Optional.of(T t)
     * 创建一个 Optional 实例
     */
    @Test
    public void optionOf(){

        Optional<Employee> op = Optional.of(employee);
        Employee e = op.get();
        System.out.println(e);
    }

    /**
     * Optional.empty()
     * Optional.ofNullable(T t)
     * 创建一个空 Optional
     */
    @Test
    public void emptyOption(){
        //会报空指针异常
        Optional<Employee> e1 = Optional.of(null);

        //也会报 NPE
        Optional<Employee> e2 = Optional.empty();
        System.out.println(e2.get());

        //不会报 NPE
        Optional<Employee> e3 = Optional.ofNullable(employee);
        System.out.println(e3.get());

        //也会报 NPE
        Optional<Employee> e4 = Optional.ofNullable(null);
        e4.get();
    }

    /**
     * isPresent
     * 是否包含值
     */
    @Test
    public void testIsPresent(){
        Optional<Employee> op = Optional.of(employee);
        if(op.isPresent()){
            op.get();
        }else{
            System.out.println("NPE");
        }
    }

    /**
     * orElse(T t)
     * 如果包含对象则返回该值，不行就返回 t
     */
    @Test
    public void testOrElse(){
        Optional<Employee> op = Optional.of(employee);
        //有值就返回值，没值就返回默认值
        Employee e = op.orElse(Employee.builder().build());
        System.out.println(e);
    }

    /**
     *
     * orElseGet(Supplier s)
     * 如果调用对象包含值，返回该值，否则返回 s 获取的值
     */
    public void orElseGet(){
        Optional<Employee> op = Optional.of(employee);
        //有值就返回值，没有就通过函数式编程获取
        Employee e = op.orElseGet(() -> Employee.builder().build());
        System.out.println(e);
    }

    /**
     * map(Function f)
     * flapMap(Function<? super T, Optional<U>> mapper)
     * 如果有值对其处理，并返回处理后的 Optional, 否则返回 Optional.empty()
     */
    public void testMap(){
        Optional<Employee> op = Optional.of(employee);
        //有值就返回值，没有就通过函数式编程获取
        Optional<String> mapResult = op.map((e) -> e.getName());
        System.out.println("map: " + mapResult.get());

        Optional<String> flapMapResult = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println("flatMap: " + flapMapResult.get());
    }
}
