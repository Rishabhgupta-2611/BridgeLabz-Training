
public class LibraryBook {

	private String title;
	private String author;
	private double price;
	private boolean availability;

	LibraryBook(String title, String author, double price, boolean availability) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.availability = availability;
	}

	void borrowBook() {
		if (availability) {
			System.out.println("Book borrowed successfully");
			availability = false;
		} else {
			System.out.println("Book is not available");
		}
	}

	void displayDetails() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
		System.out.println("Available: " + availability);
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {
		LibraryBook l1 = new LibraryBook("Wings Of Fire", "A.P.J Abdul Kalam", 500.0, true);
		l1.displayDetails();
		l1.borrowBook();
		l1.displayDetails();
		l1.borrowBook();

	}

}
