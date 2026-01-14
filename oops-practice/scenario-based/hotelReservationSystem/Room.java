package hotelReservationSystem;

abstract class Room {
	protected int roomNumber;
	protected double basePrice;
	protected boolean available = true;

	protected PricingStrategy pricingStrategy;

	public Room(int roomNumber, double basePrice, PricingStrategy pricingStrategy) {
		this.roomNumber = roomNumber;
		this.basePrice = basePrice;
		this.pricingStrategy = pricingStrategy;
	}

	public boolean isAvailable() {
		return available;
	}

	public void checkIn() {
		available = false;
	}

	public void checkOut() {
		available = true;
	}

	abstract double calculateBill(int days);

	public void displayRoom() {
		System.out.println("Room No: " + roomNumber + " | Price: ₹" + basePrice);
	}
}
