package librarymanagementsystem;

public class Faculty extends User {

	public Faculty(String name) {
		super(name);
	}

	@Override
	public void getRole() {
		System.out.println(name + " is a Faculty (extended borrowing)");
	}
}
