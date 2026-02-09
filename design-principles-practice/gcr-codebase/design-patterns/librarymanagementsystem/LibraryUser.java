package librarymanagementsystem;

public class LibraryUser implements Observer {

	private String userName;

	public LibraryUser(String userName) {
		this.userName = userName;
	}

	@Override
	public void update(String message) {
		System.out.println("Notification to " + userName + ": " + message);
	}
}
