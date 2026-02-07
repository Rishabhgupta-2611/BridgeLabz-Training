package oceanfleet;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		VesselUtil util = new VesselUtil();

		System.out.println("Enter the number of vessels to be added");
		int n = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter vessel details");
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] data = input.split(":");

			Vessel vessel = new Vessel(data[0], data[1], Double.parseDouble(data[2]), data[3]);

			util.addVesselPerformance(vessel);
		}

		System.out.println("Enter the Vessel Id to check speed");
		String searchId = sc.nextLine();

		Vessel foundVessel = util.getVesselById(searchId);

		if (foundVessel != null) {
			System.out.println(foundVessel.getVesselID() + " | " + foundVessel.getVesselName() + " | "
					+ foundVessel.getVesselType() + " | " + foundVessel.getAverageSpeed() + " knots");
		} else {
			System.out.println("Vessel Id " + searchId + " not found");
		}

		System.out.println("High performance vessels are");
		List<Vessel> highPerf = util.getHighPerformanceVessels();

		for (Vessel vessel : highPerf) {
			System.out.println(vessel.getVesselID() + " | " + vessel.getVesselName() + " | " + vessel.getVesselType()
					+ " | " + vessel.getAverageSpeed() + " knots");
		}
		sc.close();
	}
}