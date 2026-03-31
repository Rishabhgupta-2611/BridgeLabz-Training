
public class HotelBooking {

	private String guestName;
	private String roomType;
	private int nights;

	HotelBooking() {
		guestName = "Unknown";
		roomType = "Standard";
		nights = 1;
	}

	HotelBooking(String guestName, String roomType, int nights) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}

	HotelBooking(HotelBooking booking) {
		this.guestName = booking.guestName;
		this.roomType = booking.roomType;
		this.nights = booking.nights;
	}

	void displayBooking() {
		System.out.println("Guest Name: " + guestName);
		System.out.println("Room Type: " + roomType);
		System.out.println("Number of Nights: " + nights);
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {
		HotelBooking b1 = new HotelBooking();
		HotelBooking b2 = new HotelBooking("Rishabh Gupta", "Deluxe", 4);
		HotelBooking b3 = new HotelBooking(b2);
		b1.displayBooking();
		b2.displayBooking();
		b3.displayBooking();

	}

}
