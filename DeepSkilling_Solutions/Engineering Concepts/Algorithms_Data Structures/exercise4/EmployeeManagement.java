package exercise4;
public class EmployeeManagement {
    private Employee[] employees = new Employee[10];
    private int count = 0;
    public void addEmployee(Employee emp) { if(count < 10) employees[count++] = emp; }
    public Employee searchEmployee(String id) {
        for(int i=0; i<count; i++) if(employees[i].getEmployeeId().equals(id)) return employees[i];
        return null;
    }
    public void deleteEmployee(String id) {
        for(int i=0; i<count; i++) {
            if(employees[i].getEmployeeId().equals(id)) {
                for(int j=i; j<count-1; j++) employees[j] = employees[j+1];
                employees[--count] = null; return;
            }
        }
    }
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.addEmployee(new Employee("E1", "Alice"));
        System.out.println(em.searchEmployee("E1"));
    }
}
