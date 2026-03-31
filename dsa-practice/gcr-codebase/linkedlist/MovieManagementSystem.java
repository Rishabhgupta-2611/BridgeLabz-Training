class MovieNode {
	String movieTitle;
	String director;
	int yearOfRelease;
	int rating;
	MovieNode next;
	MovieNode prev;

	MovieNode(String movieTitle, String director, int yearOfRelease, int rating) {
		this.movieTitle = movieTitle;
		this.director = director;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedList {
	MovieNode head;
	MovieNode tail;

	// Add at beginning
	public void addAtBeginning(String movieTitle, String director, int yearOfRelease, int rating) {
		MovieNode node = new MovieNode(movieTitle, director, yearOfRelease, rating);

		if (head == null) {
			head = tail = node;
			return;
		}

		node.next = head;
		head.prev = node;
		head = node;
	}

	// Add at end
	public void addAtEnd(String movieTitle, String director, int yearOfRelease, int rating) {
		MovieNode node = new MovieNode(movieTitle, director, yearOfRelease, rating);

		if (head == null) {
			head = tail = node;
			return;
		}

		tail.next = node;
		node.prev = tail;
		tail = node;
	}

	// Add at specific position
	public void addAtPosition(int position, String movieTitle, String director, int yearOfRelease, int rating) {
		if (position == 1) {
			addAtBeginning(movieTitle, director, yearOfRelease, rating);
			return;
		}

		MovieNode current = head;
		for (int i = 1; i < position - 1 && current != null; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Invalid position!");
			return;
		}

		if (current.next == null) {
			addAtEnd(movieTitle, director, yearOfRelease, rating);
			return;
		}

		MovieNode node = new MovieNode(movieTitle, director, yearOfRelease, rating);
		node.next = current.next;
		node.prev = current;
		current.next.prev = node;
		current.next = node;
	}

	// Remove movie by title
	public void removeMovie(String movieTitle) {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}

		MovieNode current = head;

		while (current != null) {
			if (current.movieTitle.equalsIgnoreCase(movieTitle)) {

				if (current == head) {
					head = head.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}

				System.out.println("Movie deleted successfully");
				return;
			}
			current = current.next;
		}

		System.out.println("Movie Title not found!");
	}

	// Search by director
	void searchByDirector(String director) {
		MovieNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.director.equalsIgnoreCase(director)) {
				displayMovie(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("No movie found for this director");
	}

	// Search by rating
	void searchByRating(int rating) {
		MovieNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.rating == rating) {
				displayMovie(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("No movie found with this rating");
	}

	// Update rating
	void updateRating(String title, int newRating) {
		MovieNode temp = head;

		while (temp != null) {
			if (temp.movieTitle.equalsIgnoreCase(title)) {
				temp.rating = newRating;
				System.out.println("Rating updated successfully");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Movie not found!");
	}

	// Display forward
	void displayForward() {
		MovieNode temp = head;

		if (temp == null) {
			System.out.println("No movies available");
			return;
		}

		while (temp != null) {
			displayMovie(temp);
			temp = temp.next;
		}
	}

	// Display reverse
	void displayReverse() {
		MovieNode temp = tail;

		if (temp == null) {
			System.out.println("No movies available");
			return;
		}

		while (temp != null) {
			displayMovie(temp);
			temp = temp.prev;
		}
	}

	void displayMovie(MovieNode m) {
		System.out.println("Title: " + m.movieTitle + ", Director: " + m.director + ", Year: " + m.yearOfRelease
				+ ", Rating: " + m.rating);
	}
}

public class MovieManagementSystem {
	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		list.addAtBeginning("Inception", "Nolan", 2010, 9);
		list.addAtEnd("Interstellar", "Nolan", 2014, 8);
		list.addAtPosition(2, "Avatar", "Cameron", 2009, 7);

		System.out.println("Movies (Forward):");
		list.displayForward();

		System.out.println("Movies (Reverse):");
		list.displayReverse();

		System.out.println("Search by Director:");
		list.searchByDirector("Nolan");

		System.out.println("Update Rating:");
		list.updateRating("Avatar", 8);

		System.out.println("Remove Movie:");
		list.removeMovie("Inception");

		System.out.println("Final List:");
		list.displayForward();
	}
}
