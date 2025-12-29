import java.util.*;

public class TemperatureConverter {

	public static double fahrenheitToCelsius(double f) {
		return (f - 32) * 5 / 9;
	}

	public static double celsiusToFahrenheit(double c) {
		return (c * 9 / 5) + 32;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Fahrenheit to Celsius");
		System.out.println("2. Celsius to Fahrenheit");
		System.out.print("Choose conversion: ");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.print("Enter temperature in Fahrenheit: ");
			double f = sc.nextDouble();
			System.out.println("Temp in Celsius: " + fahrenheitToCelsius(f));
		} else if (choice == 2) {
			System.out.print("Enter temperature in Celsius: ");
			double c = sc.nextDouble();
			System.out.println("Temp in Fahrenheit: " + celsiusToFahrenheit(c));
		} else {
			System.out.println("Invalid choice");
		}

		sc.close();
	}
}
