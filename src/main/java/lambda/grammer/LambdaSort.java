package lambda.grammer;

import define_function_self.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class LambdaSort {

    /**
     * 通过定制排序比较 Employee, 先按照年龄比，再按姓名比
     */
    @Test
    public void testComparator() {
        List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).build(),
                Employee.builder().name("张三").age(20).build(),
                Employee.builder().name("李四").age(30).build()
        );
        Collections.sort(employeeList, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }
            return e1.getAge() - e2.getAge();
        });

        employeeList.forEach(System.out::println);
    }
}
