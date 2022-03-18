package stream;

import define_function_self.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class StreamSort {

    List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).salary(1000.0).build(),
                Employee.builder().name("张三").age(20).salary(10000.0).build(),
                Employee.builder().name("李四").age(30).salary(100000.0).build(),
                Employee.builder().name("晨哥").age(40).salary(10000000.0).build(),
                Employee.builder().name("晨哥").age(40).salary(10000000.0).build()
    );


    @Test
    public void sort() {
        List<String> list = Lists.newArrayList( "bbb", "ccc", "ddd","aaa");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        employeeList.stream()
                //先按工资排，工资一样按姓名排，不然就按年龄排
                .sorted((e1, e2) -> {
                    if(e1.getSalary() == e2.getSalary()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge() - e2.getAge();
                    }
                })
                .forEach(System.out::println);
    }
}
