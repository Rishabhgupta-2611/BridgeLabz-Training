package librarymanagementsystem;

public class Student extends User {

	public Student(String name) {
		super(name);
	}

	@Override
	public void getRole() {
		System.out.println(name + " is a Student (limited borrowing)");
	}
}
