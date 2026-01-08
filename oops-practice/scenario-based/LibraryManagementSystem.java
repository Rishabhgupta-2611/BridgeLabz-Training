
class Book {
	String title;
	String author;
	String status;

	Book(String title, String author, String status) {
		this.title = title;
		this.author = author;
		this.status = status;
	}
}

public class LibraryManagementSystem {

	static void displayBooks(Book[] books) {
		System.out.println("Library Books:");
		for (Book book : books) {
			System.out.println(book.title + " | " + book.author + " | " + book.status);
		}
	}

	static void searchBook(Book[] books, String keyword) {
		System.out.println("Search Results:");
		boolean found = false;

		for (Book book : books) {
			if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
				System.out.println(book.title + " | " + book.author + " | " + book.status);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No book found");
		}
	}

	static void updateStatus(Book[] books, String title) {
		for (Book book : books) {
			if (book.title.equalsIgnoreCase(title)) {
				if (book.status.equalsIgnoreCase("Available")) {
					book.status = "Checked Out";
					System.out.println("Book checked out successfully");
				} else {
					book.status = "Available";
					System.out.println("Book returned successfully");
				}
				return;
			}
		}
		System.out.println("Book not found");
	}

	public static void main(String[] args) {

		Book[] books = { new Book("Java Programming", "James Gosling", "Available"),
				new Book("Python Basics", "Guido van Rossum", "Available"),
				new Book("Data Structures", "Mark Allen", "Checked Out"),
				new Book("Web Development", "Tim Berners-Lee", "Available") };

		displayBooks(books);
		searchBook(books, "java");
		updateStatus(books, "Java Programming");
		displayBooks(books);
	}
}
