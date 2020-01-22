public class Employee {
    private String name;
    private int marks;

    public Employee(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "name=" + name + ", mark=" + marks;
    }

}