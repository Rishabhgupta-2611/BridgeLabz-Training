package cabBookingSystem;

class Ride {
	private User user;
	private Driver driver;
	private double distance;
	private double fare;

	public Ride(User user, Driver driver, double distance, FareCalculator fareCalculator) {
		this.user = user;
		this.driver = driver;
		this.distance = distance;
		this.fare = fareCalculator.calculateFare(distance);
	}

	public void rideDetails() {
		System.out.println("User: " + user.getName());
		System.out.println("Driver: " + driver.getName());
		System.out.println("Distance: " + distance + " km");
		System.out.println("Fare: ₹" + fare);
		System.out.println("----------------------------");
	}
}
