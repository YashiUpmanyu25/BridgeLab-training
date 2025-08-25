import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        // Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");

            // Validate weight
            double weight;
            while (true) {
                System.out.print("Enter weight (kg): ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                else System.out.println("Invalid! Weight must be positive.");
            }

            // Validate height
            double height;
            while (true) {
                System.out.print("Enter height (m): ");
                height = sc.nextDouble();
                if (height > 0) break;
                else System.out.println("Invalid! Height must be positive.");
            }

            weights[i] = weight;
            heights[i] = height;

            // Calculate BMI
            bmi[i] = weight / (height * height);

            // Determine status
            if (bmi[i] <= 18.4) status[i] = "Underweight";
            else if (bmi[i] <= 24.9) status[i] = "Normal";
            else if (bmi[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        // Display results
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n",
                    weights[i], heights[i], bmi[i], status[i]);
        }
    }
}
