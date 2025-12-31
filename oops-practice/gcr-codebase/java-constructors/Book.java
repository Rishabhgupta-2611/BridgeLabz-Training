
public class Book {
	private String title;
	private String author;
	private double price;

	Book(String title, String author, double price) { // Parameterized Constructors
		this.title = title;
		this.author = author;
		this.price = price;
	}

	Book() {
		title = "Unknown";
		author = "Unknown";
		price = 99.0;
	}

	void displayDetails() {
		System.out.println("Title of the book: " + title);
		System.out.println("Author of the book: " + author);
		System.out.println("Price of the book: " + price);
	}

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
		b1.displayDetails();
		b2.displayDetails();
	}

}
