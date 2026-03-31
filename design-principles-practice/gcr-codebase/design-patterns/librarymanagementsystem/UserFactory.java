package librarymanagementsystem;

public class UserFactory {

	public static User createUser(String role, String name) {

		switch (role.toLowerCase()) {
		case "student": {
			return new Student(name);
		}
		case "faculty": {
			return new Faculty(name);
		}
		case "librarian": {
			return new Faculty(name);
		}
		default: {
			throw new IllegalArgumentException("Invalid user role");
		}
		}
	}
}
