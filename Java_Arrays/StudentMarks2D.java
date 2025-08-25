import java.util.Scanner;

    public class StudentMarks2D{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();


        // 2D array → [row][0]=Physics, [row][1]=Chemistry, [row][2]=Maths
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();

            // Calculate percentage
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            // Assign grade
            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 50) grade[i] = 'C';
            else grade[i] = 'D';
        }

        // Display result
        System.out.println("\n--- Student Report ---");
        System.out.printf("%-10s %-10s %-10s %-12s %-10s %-10s%n",
                "Physics", "Chemistry", "Maths", "Percentage", "Grade", "Student");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-12.2f %-10c %-10d%n",
                    marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i], (i + 1));
        }

        sc.close();
    }
}
