package libraryManagementSystem;

public class Main {
	public static void main(String[] args) {

		Book b1 = new Book(101, "Java Programming");
		Book b2 = new Book(102, "Data Structures");

		Member student = new StudentMember("S1", "Aryan");
		Member staff = new StaffMember("T1", "Dr. Sharma");

		b1.displayBook();
		b2.displayBook();
		System.out.println();

		try {
			Transaction t1 = new Transaction(b1, student);
			t1.issue();
			t1.returnBook(3); // late by 3 days

			Transaction t2 = new Transaction(b2, staff);
			t2.issue();
			t2.returnBook(2); // late by 2 days

		} catch (BookNotAvailableException e) {
			System.out.println(e.getMessage());
		}
	}
}
