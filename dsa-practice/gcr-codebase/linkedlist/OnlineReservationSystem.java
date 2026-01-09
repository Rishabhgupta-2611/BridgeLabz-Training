
class TicketNode {
	int ticketId;
	String customerName;
	String movieName;
	String seatNumber;
	String bookingTime;
	TicketNode next;

	TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
		this.ticketId = ticketId;
		this.customerName = customerName;
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.bookingTime = bookingTime;
		this.next = null;
	}
}

class TicketReservationSystem {
	TicketNode head = null;

	void addTicket(int id, String customer, String movie, String seat, String time) {
		TicketNode newTicket = new TicketNode(id, customer, movie, seat, time);

		if (head == null) {
			head = newTicket;
			newTicket.next = head;
			return;
		}

		TicketNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = newTicket;
		newTicket.next = head;
	}

	void removeTicket(int id) {
		if (head == null) {
			System.out.println("No tickets booked");
			return;
		}

		TicketNode curr = head;
		TicketNode prev = null;

		do {
			if (curr.ticketId == id) {
				if (prev == null) { // head node
					// find last node to maintain circular link
					TicketNode last = head;
					while (last.next != head)
						last = last.next;

					head = head.next;
					last.next = head;

					if (curr == head) // only one node
						head = null;
				} else {
					prev.next = curr.next;
				}

				System.out.println("Ticket removed successfully");
				return;
			}

			prev = curr;
			curr = curr.next;
		} while (curr != head);

		System.out.println("Ticket not found");
	}

	void displayTickets() {
		if (head == null) {
			System.out.println("No tickets booked");
			return;
		}

		TicketNode temp = head;
		do {
			System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: "
					+ temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
			temp = temp.next;
		} while (temp != head);
	}

	void searchTicket(String keyword) {
		if (head == null) {
			System.out.println("No tickets booked");
			return;
		}

		boolean found = false;
		TicketNode temp = head;
		do {
			if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
				System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: "
						+ temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);

		if (!found)
			System.out.println("Ticket not found");
	}

	int totalTickets() {
		if (head == null)
			return 0;

		int count = 0;
		TicketNode temp = head;
		do {
			count++;
			temp = temp.next;
		} while (temp != head);

		return count;
	}
}

public class OnlineReservationSystem {
	public static void main(String[] args) {

		TicketReservationSystem system = new TicketReservationSystem();

		system.addTicket(101, "Aman", "Avatar", "A1", "10:00 AM");
		system.addTicket(102, "Riya", "Inception", "B5", "10:30 AM");
		system.addTicket(103, "Kunal", "Titanic", "C3", "11:00 AM");

		System.out.println("All Tickets:");
		system.displayTickets();

		System.out.println("Search by Movie Name:");
		system.searchTicket("Titanic");

		System.out.println("Remove Ticket ID 102:");
		system.removeTicket(102);
		system.displayTickets();

		System.out.println("Total Tickets: " + system.totalTickets());
	}
}
