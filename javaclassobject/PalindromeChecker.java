public class PalindromeChecker {
    String text;
    
    PalindromeChecker(String text) {
        this.text = text;
    }
    
    public boolean isPalindrome() {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversedText);
    }
    
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome");
        }
    }
    
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        PalindromeChecker checker3 = new PalindromeChecker("Madam");
        
        checker1.displayResult();
        checker2.displayResult();
        checker3.displayResult();
    }
}