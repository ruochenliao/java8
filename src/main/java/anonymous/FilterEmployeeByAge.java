package anonymous;

public class FilterEmployeeByAge implements MyStrategy<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
