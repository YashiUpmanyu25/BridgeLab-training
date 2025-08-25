import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Convert number to string for digit extraction
        String numStr = Long.toString(number);
        int len = numStr.length();

        int[] digits = new int[len];
        int[] frequency = new int[10]; // digits 0-9

        // Store digits in array
        for (int i = 0; i < len; i++) {
            digits[i] = numStr.charAt(i) - '0';  // convert char to int
            frequency[digits[i]]++;
        }

        // Display digit frequencies
        System.out.println("\n--- Digit Frequency ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }

        sc.close();
    }
}
