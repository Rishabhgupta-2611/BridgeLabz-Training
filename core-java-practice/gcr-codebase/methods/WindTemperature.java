import java.util.*;

public class WindTemperature {

	public static double calculateWindChill(double temperature, double windSpeed) {
		double result = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter temperature (°F): ");
		double temp = sc.nextDouble();
		System.out.print("Enter wind speed (mph): ");
		double windSpeed = sc.nextDouble();

		double windChill = calculateWindChill(temp, windSpeed);
		System.out.println("Wind Chill Temperature: " + windChill);

		sc.close();
	}

}
