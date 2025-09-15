import java.util.Scanner;

public class SubstringDemo {
    // Create substring using charAt()
    public static String mySubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Compare strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String sub1 = mySubstring(str, start, end);
        String sub2 = str.substring(start, end);

        System.out.println("Substring using charAt(): " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        System.out.println("Are both substrings same? " + compareStrings(sub1, sub2));
    }
}
