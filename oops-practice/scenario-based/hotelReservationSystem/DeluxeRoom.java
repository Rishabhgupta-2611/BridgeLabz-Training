package hotelReservationSystem;

class DeluxeRoom extends Room {

	public DeluxeRoom(int roomNumber, PricingStrategy pricingStrategy) {
		super(roomNumber, 4000, pricingStrategy);
	}

	double calculateBill(int days) {
		return pricingStrategy.calculatePrice(basePrice, days) + 1000; // luxury fee
	}
}
