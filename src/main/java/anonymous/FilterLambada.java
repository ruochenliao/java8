package anonymous;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterLambada {
    //原始过滤
    public List<Employee> originalFilter(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>(list.size());
        for (Employee employee : list) {
            if (employee.getAge() > 35 && employee.getSalary() > 10000) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //优化方案1 使用策略模式
    List<Employee> filterEmployee(List<Employee> list) {
        List<Employee> filterAge = strategyFilter(list, new FilterEmployeeByAge());
        return strategyFilter(filterAge, new FilterEmployeeBySalary());
    }

    private List<Employee> strategyFilter(List<Employee> list, MyStrategy<Employee> myStrategy) {
        List<Employee> employeeList = new ArrayList<>(list.size());
        for (Employee employee : list) {
            if (myStrategy.test(employee)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //优化方案2 匿名内部类
    public List<Employee> filterEmployeeInnerClass(List<Employee> list) {
        return strategyFilter(list, new MyStrategy<Employee>() {
            @Override
            public boolean test(Employee o) {
                return o.getAge() > 35;
            }
        });
    }

    //优化方案3 lambada 表达式
    public List<Employee> filterEmployeeLambada(List<Employee> list) {
        return strategyFilter(list, (e) -> e.getAge() > 35);
    }

    //优化方案4 lambada 中的 filter 表达式
    public List<Employee> filterEmployeeLambadaFilter(List<Employee> list) {
        return list.stream().filter(e->e.getAge()> 35).collect(Collectors.toList());
    }
}
