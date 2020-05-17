package anonymous;

public class FilterEmployeeBySalary implements MyStrategy<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 10000.0;
    }
}
