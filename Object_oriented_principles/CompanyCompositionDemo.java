import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    List<Employee> employees = new ArrayList<>();

    Department(String deptName) {
        this.deptName = deptName;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }

    void showEmployees() {
        System.out.println("Employees in " + deptName + " Department:");
        for (Employee e : employees) {
            System.out.println("- " + e.name);
        }
    }
}

class Company {
    String companyName;
    List<Department> departments = new ArrayList<>();

    Company(String companyName) {
        this.companyName = companyName;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showDepartments() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

public class CompanyCompositionDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("Alice"));
        d1.addEmployee(new Employee("Bob"));

        Department d2 = new Department("HR");
        d2.addEmployee(new Employee("Charlie"));

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showDepartments();
    }
}
