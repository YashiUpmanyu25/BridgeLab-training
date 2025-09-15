import java.util.*;

class Faculty {
    String name;
    Faculty(String name) { this.name = name; }
}

class DepartmentU {
    String deptName;
    DepartmentU(String deptName) { this.deptName = deptName; }
}

class University {
    String name;
    List<DepartmentU> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) { this.name = name; }

    void addDepartment(DepartmentU d) { departments.add(d); }
    void addFaculty(Faculty f) { faculties.add(f); }

    void showUniversity() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (DepartmentU d : departments) {
            System.out.println("- " + d.deptName);
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            System.out.println("- " + f.name);
        }
    }
}

public class UniversityCompositionDemo {
    public static void main(String[] args) {
        University uni = new University("IIT Delhi");

        uni.addDepartment(new DepartmentU("CSE"));
        uni.addDepartment(new DepartmentU("ECE"));

        uni.addFaculty(new Faculty("Dr. Sharma"));
        uni.addFaculty(new Faculty("Prof. Mehta"));

        uni.showUniversity();
    }
}
