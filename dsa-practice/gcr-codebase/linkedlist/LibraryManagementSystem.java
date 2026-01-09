
class BookNode {
	int bookId;
	String title;
	String author;
	String genre;
	boolean isAvailable;
	BookNode next;
	BookNode prev;

	BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isAvailable = isAvailable;
		this.next = null;
		this.prev = null;
	}
}

class LibraryDoublyLinkedList {
	BookNode head;
	BookNode tail;

	void addAtBeginning(int id, String title, String author, String genre, boolean available) {
		BookNode newNode = new BookNode(id, title, author, genre, available);

		if (head == null) {
			head = tail = newNode;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	void addAtEnd(int id, String title, String author, String genre, boolean available) {
		BookNode newNode = new BookNode(id, title, author, genre, available);

		if (head == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
		if (pos == 1) {
			addAtBeginning(id, title, author, genre, available);
			return;
		}

		BookNode temp = head;
		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null) {
			addAtEnd(id, title, author, genre, available);
			return;
		}

		BookNode newNode = new BookNode(id, title, author, genre, available);
		newNode.next = temp.next;
		newNode.prev = temp;
		temp.next.prev = newNode;
		temp.next = newNode;
	}

	void removeById(int id) {
		BookNode temp = head;

		while (temp != null) {
			if (temp.bookId == id) {

				if (temp == head) {
					head = head.next;
					if (head != null)
						head.prev = null;
				} else if (temp == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}

				System.out.println("Book removed successfully");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Book not found");
	}

	void searchByTitle(String title) {
		BookNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				displayBook(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Book not found");
	}

	void searchByAuthor(String author) {
		BookNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.author.equalsIgnoreCase(author)) {
				displayBook(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Book not found");
	}

	void updateAvailability(int id, boolean status) {
		BookNode temp = head;

		while (temp != null) {
			if (temp.bookId == id) {
				temp.isAvailable = status;
				System.out.println("Availability updated");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Book not found");
	}

	void displayForward() {
		BookNode temp = head;
		if (temp == null) {
			System.out.println("No books available");
			return;
		}

		while (temp != null) {
			displayBook(temp);
			temp = temp.next;
		}
	}

	void displayReverse() {
		BookNode temp = tail;
		if (temp == null) {
			System.out.println("No books available");
			return;
		}

		while (temp != null) {
			displayBook(temp);
			temp = temp.prev;
		}
	}

	int countBooks() {
		int count = 0;
		BookNode temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	void displayBook(BookNode b) {
		System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author + ", Genre: " + b.genre
				+ ", Available: " + (b.isAvailable ? "Yes" : "No"));
	}
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

		library.addAtBeginning(1, "Java Basics", "James", "Programming", true);
		library.addAtEnd(2, "Data Structures", "Mark", "CS", true);
		library.addAtEnd(3, "Algorithms", "Cormen", "CS", false);

		System.out.println("Books (Forward):");
		library.displayForward();

		System.out.println("Books (Reverse):");
		library.displayReverse();

		System.out.println("Search by Author:");
		library.searchByAuthor("Mark");

		System.out.println("Update Availability:");
		library.updateAvailability(3, true);

		System.out.println("Total Books: " + library.countBooks());
	}
}
