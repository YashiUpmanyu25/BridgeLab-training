// File: UniversityDemo.java
import java.util.*;

interface Graded {
    void assignGrade(String studentId, String courseCode, Object grade); // grade can be letter or boolean for pass/fail
}

abstract class Student {
    protected String id;
    protected String name;
    private Map<String, Object> grades = new HashMap<>(); // secure grade store

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setGrade(String courseCode, Object grade) {
        grades.put(courseCode, grade);
    }

    public Object getGrade(String courseCode) {
        return grades.get(courseCode);
    }

    public double calculateGPA() {
        // simple numeric mapping for demonstration
        double sum = 0;
        int count = 0;
        for (Object g : grades.values()) {
            if (g instanceof String) {
                sum += mapLetterToPoint((String) g);
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    private double mapLetterToPoint(String letter) {
        switch(letter.toUpperCase()) {
            case "A": return 10;
            case "B": return 8;
            case "C": return 6;
            case "D": return 4;
            case "F": return 0;
            default: return 0;
        }
    }

    public void printTranscript() {
        System.out.println("Transcript for " + name + " (GPA " + calculateGPA() + ")");
    }
}

class Undergraduate extends Student {
    public Undergraduate(String id, String name) { super(id, name); }
}

class Postgraduate extends Student {
    public Postgraduate(String id, String name) { super(id, name); }
}

class Course {
    String code;
    String title;
    int credits;
    public Course(String code, String title, int credits) {
        this.code = code; this.title = title; this.credits = credits;
    }
}

class Faculty implements Graded {
    private String name;
    public Faculty(String name) { this.name = name; }

    @Override
    public void assignGrade(String studentId, String courseCode, Object grade) {
        // in a real system we'd look up the student by id; here we'll simulate
        System.out.println("Faculty " + name + " assigned grade " + grade + " to student " + studentId + " for " + courseCode);
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Undergraduate s1 = new Undergraduate("S100", "Neha");
        Postgraduate s2 = new Postgraduate("S200", "Arjun");

        Course c = new Course("CS101", "Intro to CS", 3);

        // faculty assigns different grading types
        Faculty f = new Faculty("Dr. Kapoor");
        f.assignGrade(s1.id, c.code, "A");
        s1.setGrade(c.code, "A"); // we store grade in student (encapsulation)

        // pass/fail example
        f.assignGrade(s2.id, c.code, Boolean.TRUE);
        s2.setGrade(c.code, Boolean.TRUE);

        s1.printTranscript();
        s2.printTranscript();
    }
}
