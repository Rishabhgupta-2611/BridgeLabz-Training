import java.util.*;

public class TriangularPark {

	public static int calculateRounds(double a, double b, double c) {
		double perimeter = a + b + c;
		double distance = 5000; // 5 km in meters

		return (int) Math.ceil(distance / perimeter);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter side 1, 2, 3 (in meters): ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();

		int rounds = calculateRounds(a, b, c);
		System.out.println("The athlete must complete " + rounds + " rounds to run 5 km");

		sc.close();
	}

}
