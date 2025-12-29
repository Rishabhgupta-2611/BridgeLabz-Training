import java.util.Scanner;

public class BusRouteDistanceTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double totalDistance = 0.0;
		double stopDistance = 2.5; // Distance between each consecutive stop (km)
		char choice;

		System.out.println("=== Bus Route Distance Tracker ===");
		System.out.println("Each stop is " + stopDistance + " km apart.");
		System.out.println("Current stop: 1 | Total distance so far: 0 km\n");

		int currentStop = 1;

		while (true) {
			System.out.println("Stop " + currentStop);
			System.out.println("Total Distance: " + totalDistance + " km");

			System.out.print("Do you want to get off here? (y/n): ");
			choice = sc.next().charAt(0);

			if (choice == 'y' || choice == 'Y') {
				System.out.println("You got off at Stop " + currentStop);
				System.out.println("Total distance travelled: " + totalDistance + " km");
				break;
			}

			totalDistance += stopDistance;
			currentStop++;
			System.out.println();
		}

		System.out.println("Thank you for using Bus Route Tracker!");
		sc.close();
	}
}
