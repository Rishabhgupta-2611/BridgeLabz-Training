package librarymanagementsystem;

public class Librarian extends User {

	public Librarian(String name) {
		super(name);
	}

	@Override
	public void getRole() {
		System.out.println(name + " is a Librarian (manages inventory)");
	}
}
