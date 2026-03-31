package hotelReservationSystem;

class SeasonalPricing implements PricingStrategy {
	public double calculatePrice(double basePrice, int days) {
		return basePrice * days * 1.20; // 20% seasonal hike
	}
}
