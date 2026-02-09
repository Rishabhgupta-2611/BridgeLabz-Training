package librarymanagementsystem;

public class Main {
	public static void main(String[] args) {

		// Singleton
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		// Builder
		Book book = new Book.BookBuilder("Data Structures by Cormen").addAuthor("Thomas H. Cormen")
				.edition("3rd Edition").genre("Computer Science").publisher("MIT Press").build();

		catalog.addBook(book);

		// Factory
		User u1 = UserFactory.createUser("student", "Aryan");
		User u2 = UserFactory.createUser("faculty", "Dr. Sharma");

		u1.getRole();
		u2.getRole();

		// Observer
		NotificationService notificationService = new NotificationService();

		LibraryUser user1 = new LibraryUser("Aryan");
		LibraryUser user2 = new LibraryUser("Dr. Sharma");

		notificationService.subscribe(user1);
		notificationService.subscribe(user2);

		notificationService.notifyUsers("Book available: Data Structures by Cormen");
	}
}
