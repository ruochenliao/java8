package anonymous;

import java.util.ArrayList;
import java.util.List;

public class FilterLambada {
    //原始过滤
    public List<Employee> originalFilter(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>(list.size());
        for (Employee employee : list) {
            if (employee.getAge() > 35) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //优化方案1 使用策略模式
    List<Employee> filterEmployee(List<Employee> list){
        FilterEmployeeByAge filterEmployeeByAge = new FilterEmployeeByAge();
        return strategyFilter(list, filterEmployeeByAge);
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
}
