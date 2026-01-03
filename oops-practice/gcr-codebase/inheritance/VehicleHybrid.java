interface Refuelable {
	void refuel();
}

class BaseVehicle {
	int maxSpeed;
	String model;

	BaseVehicle(int maxSpeed, String model) {
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
}

class ElectricVehicle extends BaseVehicle {
	ElectricVehicle(int maxSpeed, String model) {
		super(maxSpeed, model);
	}

	void charge() {
		System.out.println(model + " is charging.");
	}
}

class PetrolVehicle extends BaseVehicle implements Refuelable {
	PetrolVehicle(int maxSpeed, String model) {
		super(maxSpeed, model);
	}

	@Override
	public void refuel() {
		System.out.println(model + " is refueling with petrol.");
	}
}

public class VehicleHybrid {
	public static void main(String[] args) {
		ElectricVehicle ev = new ElectricVehicle(150, "EV-X");
		PetrolVehicle pv = new PetrolVehicle(180, "Petrocar");

		ev.charge();
		pv.refuel();
	}
}