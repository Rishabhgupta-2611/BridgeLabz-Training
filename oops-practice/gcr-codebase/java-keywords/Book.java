
public class Book {

	private static String libraryName = "Egmore Library";

	private static void displayLibraryName() {
		System.out.println("Library Name: " + libraryName);
	}

	private String title;
	private String author;
	private final long isbn;

	Book(String title, String author, long isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public void displayDetails() {
		if (this instanceof Book) {
			System.out.println("Title: " + title);
			System.out.println("Author: " + author);
			System.out.println("ISBN: " + isbn);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public static void main(String[] args) {
		Book b1 = new Book("java", "Joshua Bloch", 9780134685991L);
		displayLibraryName();
		b1.displayDetails();
	}
}
