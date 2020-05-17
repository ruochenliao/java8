package anonymous;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        AnonymousLambada anonymousLambada = new AnonymousLambada();

        //原始的比较器
        TreeSet<Integer> originalComparator = anonymousLambada.originalComparator();
        originalComparator.add(2);
        originalComparator.add(1);
        originalComparator.add(3);
        for (int i : originalComparator) {
            System.out.println(i);
        }

        //使用 lambda 的比较器
        TreeSet<Integer> lambadaComparator = anonymousLambada.lambadaComparator();
        for (int i : lambadaComparator) {
            System.out.println(i);
        }

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().age(20).name("张三").salary(10000).build(),
                Employee.builder().age(30).name("李四").salary(20000).build(),
                Employee.builder().age(40).name("王五").salary(30000).build()
        );

        FilterLambada filterLambada = new FilterLambada();
        List<Employee> filteredListOriginal = filterLambada.originalFilter(employeeList);
        List<Employee> filteredListStrategy = filterLambada.filterEmployee(employeeList);

        for (Employee employee : filteredListOriginal) {
            System.out.println(JSON.toJSONString(employee));
        }
        for (Employee employee : filteredListStrategy) {
            System.out.println(JSON.toJSONString(employee));
        }
    }
}
