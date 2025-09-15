import java.util.Scanner;

public class StringIndexDemo {
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length() + 1)); // beyond limit
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        //generateException(str); // Uncomment to crash
        handleException(str);
    }
}
