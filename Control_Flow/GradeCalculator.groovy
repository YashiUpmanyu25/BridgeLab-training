import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();

        double avg = (physics + chemistry + maths) / 3.0;
        System.out.println("Average Marks = " + avg + "%");

        if (avg >= 80) {
            System.out.println("Grade: A (Above agency-normalized standards)");
        } else if (avg >= 70) {
            System.out.println("Grade: B (At agency-normalized standards)");
        } else if (avg >= 60) {
            System.out.println("Grade: C (Below, but approaching standards)");
        } else if (avg >= 50) {
            System.out.println("Grade: D (Well below standards)");
        } else if (avg >= 40) {
            System.out.println("Grade: E (Too below standards)");
        } else {
            System.out.println("Grade: R (Remedial standards)");
        }
    }
}
