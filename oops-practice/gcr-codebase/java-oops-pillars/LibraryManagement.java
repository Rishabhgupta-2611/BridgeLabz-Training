interface Resevable{
    void reserveItem(String itemId);
    void checkAvailability(String itemId);
}
abstract class LibraryItem implements Resevable {
    private String title;
    private String author;
    private String itemId;

    public LibraryItem(String title, String author, String itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }
    public String getItemId() {
        return itemId;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public abstract void displayItemDetails();
    public abstract void getLoanDuration();
}
class Book extends LibraryItem {
    private String genre;

    public Book(String title, String author, String itemId, String genre) {
        super(title, author, itemId);
        this.genre = genre;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Book Title: " + getTitle() + ", Author: " + getAuthor() + ", Genre: " + genre);
    }

    @Override
    public void getLoanDuration() {
        System.out.println("Loan Duration for Book: 14 days");
    }
    public void reserveItem(String itemId) {
        System.out.println("Book with ID " + itemId + " has been reserved.");
    }
    public void checkAvailability(String itemId) {
        System.out.println("Book with ID " + itemId + " is available.");
    }
}
class Magazine extends LibraryItem {
    private String issueNumber;

    public Magazine(String title, String author, String itemId, String issueNumber) {
        super(title, author, itemId);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Magazine Title: " + getTitle() + ", Author: " + getAuthor() + ", Issue Number: " + issueNumber);
    }

    @Override
    public void getLoanDuration() {
        System.out.println("Loan Duration for Magazine: 7 days");
    }
    public void reserveItem(String itemId) {
        System.out.println("Magazine with ID " + itemId + " has been reserved.");
    }
    public void checkAvailability(String itemId) {
        System.out.println("Magazine with ID " + itemId + " is available.");
    }
}
class DVD extends LibraryItem {
    private String director;

    public DVD(String title, String author, String itemId, String director) {
        super(title, author, itemId);
        this.director = director;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("DVD Title: " + getTitle() + ", Director: " + director);
    }

    @Override
    public void getLoanDuration() {
        System.out.println("Loan Duration for DVD: 5 days");
    }
    public void reserveItem(String itemId) {
        System.out.println("DVD with ID " + itemId + " has been reserved.");
    }
    public void checkAvailability(String itemId) {
        System.out.println("DVD with ID " + itemId + " is available.");
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "B001", "Fiction");
        book.displayItemDetails();
        book.getLoanDuration();
        book.reserveItem("B001");
        book.checkAvailability("B001");

        LibraryItem magazine = new Magazine("National Geographic", "Various", "M001", "2023-09");
        magazine.displayItemDetails();
        magazine.getLoanDuration();
        magazine.reserveItem("M001");
        magazine.checkAvailability("M001");

        LibraryItem dvd = new DVD("Inception", "Christopher Nolan", "D001", "Christopher Nolan");
        dvd.displayItemDetails();
        dvd.getLoanDuration();
        dvd.reserveItem("D001");
        dvd.checkAvailability("D001");
    }
}
