import java.util.*;

class Course {
    String name;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void enrollStudent(Student s) {
        students.add(s);
        s.courses.add(this);
    }

    void showStudents() {
        System.out.println("Students in course " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void viewCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class School {
    String name;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolAggregationDemo {
    public static void main(String[] args) {
        School school = new School("Green Valley");

        Student s1 = new Student("Pragati");
        Student s2 = new Student("Unnati");

        school.addStudent(s1);
        school.addStudent(s2);

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        c1.enrollStudent(s1);
        c2.enrollStudent(s1);
        c2.enrollStudent(s2);

        s1.viewCourses();
        s2.viewCourses();
        c2.showStudents();
    }
}
