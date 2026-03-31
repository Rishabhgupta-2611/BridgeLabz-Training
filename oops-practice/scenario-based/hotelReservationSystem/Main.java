package hotelReservationSystem;

public class Main {

	public static void main(String[] args) {

		try {
			PricingStrategy seasonalPricing = new SeasonalPricing();

			Room r1 = new StandardRoom(101, seasonalPricing);
			Room r2 = new DeluxeRoom(201, seasonalPricing);

			Guest g1 = new Guest("Aryan", "9999999999");

			Reservation reservation = new Reservation(g1, r2, 3);

			reservation.checkIn();
			reservation.checkOut();

		} catch (RoomNotAvailableException e) {
			System.out.println(e.getMessage());
		}
	}
}
