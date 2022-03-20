package lambda.commonUse;

import com.google.common.collect.Lists;
import define_function_self.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * isPresent 在 Optional 找到一个存在的，返回 true, 否则返回 false
 * ifPresent(Consumer<T> block) 会在值存在的时候执行代码
 * get 如果存在则返回，不存在则抛  NoSuchEmlement 异常
 * orElse 会在值存在的时候返回值，不存在的时候返回 null
 */
public class OptionalUse {
    @Test
    public void testNull(){
        List<Employee> employeeList = newEmployees();
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(e->e.getAge() > 30)
                .findAny();
        if(optionalEmployee.isPresent()){
            System.out.println("find you");
        }

        //如果存在则返回，不存在则抛  NoSuchEmlement 异常
        optionalEmployee.get();

        Employee employee = optionalEmployee.orElse(null);
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
