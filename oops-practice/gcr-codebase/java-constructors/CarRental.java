
public class CarRental {

	private String customerName;
	private String carModel;
	private int rentalDays;
	double costPerDay = 1500;

	CarRental() {
		customerName = "Unknown";
		carModel = "Standard";
		rentalDays = 1;
	}

	CarRental(String customerName, String carModel, int rentalDays) {
		this.customerName = customerName;
		this.carModel = carModel;
		this.rentalDays = rentalDays;
	}

	double calculateTotalCost() {
		return rentalDays * costPerDay;
	}

	void displayDetails() {
		System.out.println("Customer Name: " + customerName);
		System.out.println("Car Model: " + carModel);
		System.out.println("Rental Days: " + rentalDays);
		System.out.println("Total Cost: " + calculateTotalCost());
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {
		CarRental r1 = new CarRental();
		r1.displayDetails();
		CarRental r2 = new CarRental("Rishabh Gupta", "Hyundai Creta", 3);
		r2.displayDetails();
	}

}
