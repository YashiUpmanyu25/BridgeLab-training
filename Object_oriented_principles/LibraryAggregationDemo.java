import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

class Library {
    String name;
    List<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book b : books) {
            System.out.println("- " + b);
        }
    }
}

public class LibraryAggregationDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("Clean Code", "Robert C. Martin");

        Library lib1 = new Library("Central");
        Library lib2 = new Library("City");

        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b3);

        lib1.showBooks();
        lib2.showBooks();
    }
}
