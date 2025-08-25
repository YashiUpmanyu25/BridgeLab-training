import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int sum = 0, temp = number;

        while (temp > 0) {
            sum += temp % 10; // add digit
            temp /= 10;       // remove digit
        }

        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is NOT a Harshad Number");
        }
    }
}
