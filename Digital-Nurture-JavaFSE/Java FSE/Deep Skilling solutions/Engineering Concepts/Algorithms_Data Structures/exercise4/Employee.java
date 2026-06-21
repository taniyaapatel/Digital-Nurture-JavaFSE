package exercise4;
public class Employee {
    private String employeeId;
    private String name;
    public Employee(String employeeId, String name) { this.employeeId = employeeId; this.name = name; }
    public String getEmployeeId() { return employeeId; }
    @Override
    public String toString() { return "Employee{" + employeeId + " " + name + '}'; }
}
