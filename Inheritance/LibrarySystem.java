// Author class
class Author {
    private String name;
    private String bio;

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public void displayAuthor() {
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Book class (uses composition)
class Book {
    private String title;
    private int publicationYear;
    private Author author;  // ✅ Book HAS an Author

    public Book(String title, int publicationYear, Author author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        author.displayAuthor(); // delegate responsibility
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        Author a1 = new Author("F. Scott Fitzgerald", "American novelist, Jazz Age icon");
        Book b1 = new Book("The Great Gatsby", 1925, a1);

        b1.displayInfo();
    }
}
