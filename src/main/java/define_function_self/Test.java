package define_function_self;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 自定义函数
 */
public class Test {
    public static void main(String[] args) {
        AnonymousLambada anonymousLambada = new AnonymousLambada();

        TreeSet<Integer> originalComparator = anonymousLambada.originalComparator();
        originalComparator.add(2);
        originalComparator.add(1);
        originalComparator.add(3);
        System.out.println("原始的比较器");
        for (int i : originalComparator) {
            System.out.println(i);
        }

        System.out.println("使用 lambda 的比较器");
        TreeSet<Integer> lambadaComparator = anonymousLambada.lambadaComparator();
        lambadaComparator.add(2);
        lambadaComparator.add(1);
        lambadaComparator.add(3);
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
        List<Employee> filterListInnerClass = filterLambada.filterEmployeeInnerClass(employeeList);
        List<Employee> filterEmployeeLambada = filterLambada.filterEmployeeLambada(employeeList);
        List<Employee> filterEmployeeLambadaFilter = filterLambada.filterEmployeeLambadaFilter(employeeList);
        System.out.println("原始过滤");
        for (Employee employee : filteredListOriginal) {
            System.out.println(JSON.toJSONString(employee));
        }
        System.out.println("策略过滤");
        for (Employee employee : filteredListStrategy) {
            System.out.println(JSON.toJSONString(employee));
        }
        System.out.println("匿名内部类");
        for (Employee employee : filterListInnerClass) {
            System.out.println(JSON.toJSONString(employee));
        }
        System.out.println("lambada 表达式");
        for (Employee employee :filterEmployeeLambada){
            System.out.println(JSON.toJSONString(employee));
        }
        System.out.println("lambada stream api");
        for (Employee employee :filterEmployeeLambadaFilter){
            System.out.println(JSON.toJSONString(employee));
        }
    }
}
