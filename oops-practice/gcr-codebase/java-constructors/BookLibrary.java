
public class BookLibrary {

	public String ISBN;
	protected String title;
	private String author;

	BookLibrary(String ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() { // Getter & Setter for private
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

class EBook extends BookLibrary { // Subclass

	EBook(String ISBN, String title, String author) {
		super(ISBN, title, author);
	}

	void displayDetails() {
		System.out.println("ISBN: " + ISBN); // public
		System.out.println("Title: " + title); // protected
		System.out.println("Author: " + getAuthor());
	}

	public static void main(String[] args) {
		EBook ebook = new EBook("ISBN123", "Java Programming", "James Gosling");
		ebook.displayDetails();
	}
}
