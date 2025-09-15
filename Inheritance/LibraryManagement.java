// Superclass Book
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author
class Author extends Book {
    private String authorName;
    private String bio;

    public Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

// Main class to test
public class LibraryManagement {
    public static void main(String[] args) {
        Author a1 = new Author(
            "The Great Gatsby",
            1925,
            "F. Scott Fitzgerald",
            "American novelist known for works depicting the Jazz Age."
        );

        System.out.println("=== Book & Author Details ===");
        a1.displayInfo();
    }
}
