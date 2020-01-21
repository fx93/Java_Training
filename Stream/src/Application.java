import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("Tharsi", 80));
        employee.add(new Employee("Ganes", 60));
        employee.add(new Employee("Kajanan", 45));
        employee.add(new Employee("Kumar", 26));
        employee.add(new Employee("Puvi", 95));
        employee.add(new Employee("Sayee", 79));
        employee.add(new Employee("Bavan", 96));
        employee.add(new Employee("Karan", 87));
        employee.add(new Employee("David", 59));
        employee.add(new Employee("Dami", 61));

        List<Employee> mapEmployee = employee.stream()
                .filter(e -> e.getMarks() > 60).sorted(Comparator.comparing(Employee::getName))
                .map(e -> new Employee("Mr." + e.getName(), e.getMarks()))
                .collect(Collectors.toList());

        System.out.println(mapEmployee);
    }
}
