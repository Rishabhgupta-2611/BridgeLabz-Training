
class Device {
	protected String deviceId;
	protected String status;

	public Device(String deviceId, String status) {
		this.deviceId = deviceId;
		this.status = status;
	}

	public void displayStatus() {
		System.out.println("Device ID: " + deviceId + ", Status: " + status);
	}
}

class Thermostat extends Device {
	private int temperature;

	public Thermostat(String deviceId, String status, int temperature) {
		super(deviceId, status);
		this.temperature = temperature;
	}

	public void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature: " + temperature);
	}
}

class Light extends Device {
	private int brightness;

	public Light(String deviceId, String status, int brightness) {
		super(deviceId, status);
		this.brightness = brightness;
	}

	public void displayStatus() {
		super.displayStatus();
		System.out.println("Brightness: " + brightness);
	}
}

public class SmartHomeDevices {
	public static void main(String[] args) {
		Device device = new Device("D001", "ON");
		device.displayStatus();
		Light light = new Light("L001", "ON", 80);
		light.displayStatus();
		Thermostat thermostat = new Thermostat("T001", "ON", 72);
		thermostat.displayStatus();
	}
}
