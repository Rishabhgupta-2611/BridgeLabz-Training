import java.util.*;

interface Insurable {
	double calculateInsurance();

	void getInsuranceDetails();
}

abstract class Vehicle {
	private String vehicleNumber;
	private String type;
	private int rentalRate;

	private String insurancePolicyNumber;

	public Vehicle(String vehicleNumber, String type, int rentalRate, String insurancePolicyNumber) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public int getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(int rentalRate) {
		this.rentalRate = rentalRate;
	}

	protected String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	abstract int calculateRentalCost(int days);

	void displayDetails() {
		System.out.println("Vehicle Number      : " + vehicleNumber);
		System.out.println("vehicle Type        : " + type);
		System.out.println("Vehicle Rental Rate : " + rentalRate);
	}
}

class Car extends Vehicle implements Insurable {

	public Car(String vehicleNumber, String type, int rentalRate, String insurancePolicyNumber) {
		super(vehicleNumber, type, rentalRate, insurancePolicyNumber);
	}

	public int calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	public double calculateInsurance() {
		return 500.0;
	}

	public void getInsuranceDetails() {
		System.out.println("Insurance Type      : Car Insurance");
	}
}

class Bike extends Vehicle implements Insurable {

	public Bike(String vehicleNumber, String type, int rentalRate, String insurancePolicyNumber) {
		super(vehicleNumber, type, rentalRate, insurancePolicyNumber);
	}

	public int calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	public double calculateInsurance() {
		return 200.0;
	}

	public void getInsuranceDetails() {
		System.out.println("Insurance Type      : Bike Insurance");
	}
}

class Truck extends Vehicle implements Insurable {

	public Truck(String vehicleNumber, String type, int rentalRate, String insurancePolicyNumber) {
		super(vehicleNumber, type, rentalRate, insurancePolicyNumber);
	}

	public int calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	public double calculateInsurance() {
		return 1000.0;
	}

	public void getInsuranceDetails() {
		System.out.println("Insurance Type      : Truck Insurance");
	}
}

public class VehicleRentalSystem {

	public static void main(String[] args) {

		List<Vehicle> vehicleList = new ArrayList<>();

		Vehicle v1 = new Car("UP32AB1234", "Car", 1500, "CAR-INS-101");
		Vehicle v2 = new Bike("UP32XY5678", "Bike", 500, "BIKE-INS-202");
		Vehicle v3 = new Truck("UP32TR9999", "Truck", 3000, "TRUCK-INS-303");

		vehicleList.add(v1);
		vehicleList.add(v2);
		vehicleList.add(v3);

		int days = 3;

		for (Vehicle vehicle : vehicleList) {
			System.out.println("----------------------------");
			vehicle.displayDetails();

			int rentalCost = vehicle.calculateRentalCost(days);
			System.out.println("Rental Cost (" + days + " days): " + rentalCost);

			Insurable ins = (Insurable) vehicle;
			double insuranceCost = ins.calculateInsurance();
			ins.getInsuranceDetails();

			System.out.println("Insurance Cost      : " + insuranceCost);
			System.out.println("Total Cost          : " + (rentalCost + insuranceCost));
		}
	}
}