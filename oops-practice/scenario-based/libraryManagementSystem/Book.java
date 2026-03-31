package libraryManagementSystem;

class Book {
	private int bookId;
	private String title;
	private boolean available = true;

	public Book(int bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void issueBook() throws BookNotAvailableException {
		if (!available) {
			throw new BookNotAvailableException("Book not available: " + title);
		}
		available = false;
	}

	public void returnBook() {
		available = true;
	}

	public String getTitle() {
		return title;
	}

	public void displayBook() {
		System.out.println(bookId + " | " + title + " | Status: " + (available ? "Available " : "Issued "));
	}
}
