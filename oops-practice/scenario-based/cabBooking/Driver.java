package cabBooking;

class Driver {
	private int driverId;
	private String name;
	private boolean available;

	public Driver(int driverId, String name) {
		this.driverId = driverId;
		this.name = name;
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void assignDriver() {
		available = false;
	}

	public void releaseDriver() {
		available = true;
	}

	public String getName() {
		return name;
	}
}
