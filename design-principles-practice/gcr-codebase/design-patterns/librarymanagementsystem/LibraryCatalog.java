//1: Singleton Pattern – Centralized Library Catalog
package librarymanagementsystem;
import java.util.*;

public class LibraryCatalog {

    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();

    // private constructor
    private LibraryCatalog() {}

	// global access point
    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public boolean isBookAvailable(String title) {
        return books.stream().anyMatch(b -> b.getTitle().equalsIgnoreCase(title));
    }
}
