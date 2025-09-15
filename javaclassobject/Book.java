public class Book {
    String title;
    String author;
    double price;
    
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("2States", "Chetan Bhagat", 500);
        Book book2 = new Book("Wings Of Fire", "Abdul Kalam", 500);
        
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}