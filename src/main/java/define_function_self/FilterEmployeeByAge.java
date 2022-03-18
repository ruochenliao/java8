package define_function_self;

public class FilterEmployeeByAge implements MyStrategy<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
