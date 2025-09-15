import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String str) {
        System.out.println(str.substring(5, 2)); // invalid
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        //generateException(str); // crash
        handleException(str);
    }
}
