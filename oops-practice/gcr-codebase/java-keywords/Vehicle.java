public class Vehicle {

	private static double registrationFee = 150.0;

	public static void updateRegistrationFee(double fee) {
		registrationFee = fee;
	}

	private final String registrationNumber;
	private String ownerName;
	private String vehicleType;

	Vehicle(String registrationNumber, String ownerName, String vehicleType) {
		this.registrationNumber = registrationNumber;
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}

	public void displayVehicleDetails() {
		if (this instanceof Vehicle) {
			System.out.println("Owner Name: " + ownerName);
			System.out.println("Vehicle Type: " + vehicleType);
			System.out.println("Registration Number: " + registrationNumber);
			System.out.println("Registration Fee: $" + registrationFee);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("ABC123", "Honest raj", "Sedan");
		Vehicle v2 = new Vehicle("XYZ789", "Price danish", "SUV");
		v1.displayVehicleDetails();
		v2.displayVehicleDetails();
	}
}
