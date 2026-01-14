package hotelReservationSystem;

class StandardRoom extends Room {

	public StandardRoom(int roomNumber, PricingStrategy pricingStrategy) {
		super(roomNumber, 2000, pricingStrategy);
	}

	double calculateBill(int days) {
		return pricingStrategy.calculatePrice(basePrice, days);
	}
}
