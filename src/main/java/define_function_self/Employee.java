package define_function_self;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
    private String name;
    private int age;
    private double salary;
    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VACATION;
    }
}
