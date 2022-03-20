package lambda.commonUse;

import define_function_self.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCompare {

    List<Employee> newEmployees(){
        List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).build(),
                Employee.builder().name("张三").age(20).build(),
                Employee.builder().name("李四").age(30).build()
        );

        return employeeList;
    }

    /**
     * 通过定制排序比较 Employee, 先按照年龄比，再按姓名比
     */
    @Test
    public void testComparator() {

        List<Employee> employeeList = newEmployees();
        //老版排序
        Collections.sort(employeeList, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }
            return e1.getAge() - e2.getAge();
        });

        employeeList.forEach(System.out::println);

        //或者
        employeeList.sort((Employee e1, Employee e2) -> e1.getAge() - e2.getAge());

        //或者
        employeeList.sort(Comparator.comparingInt(Employee::getAge));
    }

    //逆序比较
    @Test
    public void testReverseCompare(){
        List<Employee> employeeList = newEmployees();
        employeeList.sort(Comparator.comparing(Employee::getAge).reversed());
    }

    //比较链
    @Test
    public void testChainCompare(){
        List<Employee> employeeList = newEmployees();
        //先比较重量再比较名字
        employeeList.sort(Comparator.comparing(Employee::getAge)
                .reversed()
                .thenComparing(Employee::getName)
        );
    }
}
