import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int count = 0;
        int temp = Math.abs(number); // in case of negative input

        if (temp == 0) count = 1;
        else {
            while (temp != 0) {
                temp /= 10;
                count++;
            }
        }

        System.out.println("Number of digits in " + number + " = " + count);
    }
}
