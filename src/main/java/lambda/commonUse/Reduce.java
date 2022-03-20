package lambda.commonUse;

import com.google.common.collect.Lists;
import define_function_self.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * stream.reduce(init, BinaryOperator)
 * 第一个是初始值，第二个是元素操作
 *
 */
public class Reduce {

    @Test
    public void sumUp(){
        //求和
        int sum = newEmployees().stream().map(Employee::getAge).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // 求最小值
        Optional<Integer> min = newEmployees().stream().map(Employee::getAge).reduce((a, b) -> a < b? a:b);
    }

    List<Employee> newEmployees(){
        List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).build(),
                Employee.builder().name("张三").age(20).build(),
                Employee.builder().name("李四").age(30).build()
        );

        return employeeList;
    }
}
