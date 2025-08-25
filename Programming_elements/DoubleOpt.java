import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        // Performing double operations
        double result1 = a + b * c;   // Multiplication before addition
        double result2 = a * b + c;   // Multiplication first, then addition
        double result3 = c + a / b;   // Division before addition
        double result4 = a % b + c;   // Modulus before addition

        // Output
        System.out.println("The results of Double Operations are "
                           + result1 + ", " + result2 + ", " + result3 + ", and " + result4);

        sc.close();
    }
}