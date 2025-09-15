import java.util.Scanner;

public class ArrayIndexDemo {
    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]); // invalid index
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        String[] arr = new String[n];

        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        //generateException(arr);
        handleException(arr);
    }
}
