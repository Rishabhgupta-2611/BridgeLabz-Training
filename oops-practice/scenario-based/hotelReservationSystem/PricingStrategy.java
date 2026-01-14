package hotelReservationSystem;

interface PricingStrategy {
	double calculatePrice(double basePrice, int days);
}
