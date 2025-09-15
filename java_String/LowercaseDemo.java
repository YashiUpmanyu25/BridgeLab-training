import java.util.Scanner;

public class LowercaseDemo {
    // Convert manually
    public static String toLowerManual(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String str = sc.nextLine();

        String manual = toLowerManual(str);
        String builtin = str.toLowerCase();

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
        System.out.println("Are both same? " + compareStrings(manual, builtin));
    }
}
