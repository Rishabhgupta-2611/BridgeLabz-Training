package cabBookingSystem;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		User user1 = new User(1, "Rishabh");

		Driver d1 = new Driver(101, "Amit");
		Driver d2 = new Driver(102, "Rahul");

		List<Driver> drivers = Arrays.asList(d1, d2);
		RideService service = new RideService(drivers);

		FareCalculator normalFare = new NormalFare();
		FareCalculator peakFare = new PeakFare();

		try {
			Ride ride1 = service.bookRide(user1, 12, normalFare);
			ride1.rideDetails();

			Ride ride2 = service.bookRide(user1, 8, peakFare);
			ride2.rideDetails();

		} catch (NoDriverAvailableException e) {
			System.out.println(e.getMessage());
		}

		service.showRideHistory();
	}
}
