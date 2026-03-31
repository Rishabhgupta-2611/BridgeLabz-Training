
public class MovieTicket {

	boolean booked = false;

	void bookTicket(String movieName, String seatNumber, double price) {

		if (booked) {
			System.out.println("House full!!! sorry..... Ticket already booked");
		} else {
			booked = true;
			System.out.println("Ticket booked for movie: " + movieName);
			System.out.println("Seat Number: " + seatNumber);
			System.out.println("Price: $" + price);
		}
	}

	public static void main(String[] args) {
		MovieTicket ticket = new MovieTicket();

		System.out.println("Ticket have not booked yet....");
		ticket.bookTicket("Dragon", "A10", 120.0);
		ticket.bookTicket("Dragon", "A10", 120.0);
	}
}
