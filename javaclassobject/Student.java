public class Student {
    String name;
    String rollNumber;
    double[] marks;
    
    Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    public String calculateGrade() {
        double average = calculateAverage();
        
        if (average >= 80) {
            return "Grade A";
        } else if (average >= 60) {
            return "Grade B";
        } else if (average >= 50) {
            return "Grade C";
        } else if (average >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }
    
    public double calculateAverage() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }
    
    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Marks:");
        
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
        }
        
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
    
    public static void main(String[] args) {
        double[] marks1 = {80, 70, 75};
        double[] marks2 = {60, 65, 50};
        
        Student student1 = new Student("Thamarai", "ECE001", marks1);
        Student student2 = new Student("Kannan", "CSC002", marks2);
        
        student1.displayStudent();
        System.out.println();
        student2.displayStudent();
    }
}