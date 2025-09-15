import java.util.*;

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String id) { this.employeeId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double s) { this.baseSalary = s; }

    public void displayDetails() {
        System.out.printf("ID: %s, Name: %s, Base Salary: %.2f%n", employeeId, name, baseSalary);
    }

    public abstract double calculateSalary();
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double allowance;

    public FullTimeEmployee(String id, String name, double base, double allowance) {
        super(id, name, base);
        this.allowance = allowance;
    }

    public double getAllowance() { return allowance; }
    public void setAllowance(double a) { allowance = a; }

    @Override
    public double calculateSalary() {
        // example: baseSalary + allowance
        return getBaseSalary() + allowance;
    }

    @Override
    public void assignDepartment(String dept) { this.department = dept; }

    @Override
    public String getDepartmentDetails() { return department == null ? "No Dept" : department; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Type: FullTime, Allowance: %.2f, Department: %s, Total Salary: %.2f%n",
            allowance, getDepartmentDetails(), calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double base, int hours, double rate) {
        super(id, name, base);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int h) { hoursWorked = h; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double r) { hourlyRate = r; }

    @Override
    public double calculateSalary() {
        // example: base + hours*rate
        return getBaseSalary() + hoursWorked * hourlyRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Type: PartTime, Hours: %d, Rate: %.2f, Total Salary: %.2f%n",
            hoursWorked, hourlyRate, calculateSalary());
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee f1 = new FullTimeEmployee("F001","Alice",50000,8000);
        f1.assignDepartment("Engineering");

        PartTimeEmployee p1 = new PartTimeEmployee("P001","Bob",10000,80,150);

        employees.add(f1);
        employees.add(p1);

        System.out.println("Employee Details:");
        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("---");
        }
    }
}
