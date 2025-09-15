public class NullPointerDemo {
    // Method that generates exception
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will throw NullPointerException
    }

    // Method that handles exception
    public static void handleException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: " + e);
        }
    }

    public static void main(String[] args) {
        //generateException(); // Uncomment to see program crash
        handleException();
    }
}
