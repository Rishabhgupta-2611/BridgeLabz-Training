public class DigitalWatchSimulation {
	public static void main(String[] args) {

		for (int hour = 0; hour < 24; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				System.out.printf("%02d:%02d\n", hour, minute);
				if (hour == 13 && minute == 0) { // Stop at 13:00
					System.out.println("Power cut! Watch stopped at 13:00.");
					break;
				}
			}

			if (hour == 13) { // Check again to break outer loop if power cut
				break;
			}
		}

		System.out.println("Simulation ended.");
	}
}
