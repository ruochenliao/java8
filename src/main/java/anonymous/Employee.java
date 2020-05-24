package anonymous;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
    private String name;
    private int age;
    private double salary;
}
