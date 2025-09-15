import java.util.Scanner;

public class CharArrayDemo {
    // Convert string to char array manually
    public static char[] myToCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    // Compare two char arrays
    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] arr1 = myToCharArray(str);
        char[] arr2 = str.toCharArray();

        System.out.println("Are both arrays same? " + compareArrays(arr1, arr2));
    }
}
