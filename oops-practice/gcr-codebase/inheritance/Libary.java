
class Book {
	private String title;
	private int publicationYear;

	public Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}

	public void displayInfo() {
		System.out.println(title);
		System.out.println(publicationYear);
	}
}

class Author extends Book {
	private String name;
	private String bio;

	public Author(String title, int year, String name, String bio) {
		super(title, year);
		this.name = name;
		this.bio = bio;
	}

	public void displayInfo() {
		System.out.println("name : " + name);
		System.out.println("bio : " + bio);
		super.displayInfo();
		System.out.println("------------------------");
	}
}

public class Libary {
	public static void main(String[] args) {
		Book b = new Author("Harry poter", 2025, "J k Rowling", "here is the book named as harrry potter ");
		b.displayInfo();
	}
}
