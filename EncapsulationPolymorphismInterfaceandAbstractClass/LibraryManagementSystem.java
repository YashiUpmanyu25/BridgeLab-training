import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String id, String title, String author) {
        this.itemId = id; this.title = title; this.author = author;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String id) { itemId = id; }

    public String getTitle() { return title; }
    public void setTitle(String t) { title = t; }

    public String getAuthor() { return author; }
    public void setAuthor(String a) { author = a; }

    public void getItemDetails() {
        System.out.printf("%s - %s by %s%n", itemId, title, author);
    }

    public abstract int getLoanDuration(); // in days
}

interface Reservable {
    boolean reserveItem(String userId);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(String id, String title, String author) { super(id,title,author); }

    @Override
    public int getLoanDuration() { return 21; }

    @Override
    public boolean reserveItem(String userId) {
        if (available) { available = false; return true; }
        return false;
    }

    @Override
    public boolean checkAvailability() { return available; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id,title,author); }
    @Override
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) { super(id,title,author); }
    @Override
    public int getLoanDuration() { return 3; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        Book b = new Book("B001","Clean Code","Robert C. Martin");
        Magazine m = new Magazine("M001","Tech Monthly","Editorial");
        DVD d = new DVD("D001","Inception","Nolan");

        items.add(b); items.add(m); items.add(d);

        for (LibraryItem li : items) {
            li.getItemDetails();
            System.out.println("  Loan Days: " + li.getLoanDuration());
            if (li instanceof Reservable) {
                Reservable r = (Reservable) li;
                System.out.println("  Available? " + r.checkAvailability());
                System.out.println("  Reserving -> " + r.reserveItem("user123"));
                System.out.println("  Available now? " + r.checkAvailability());
            }
            System.out.println("---");
        }
    }
}
