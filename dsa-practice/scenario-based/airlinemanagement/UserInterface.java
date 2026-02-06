package airlinemanagement;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter flight details");

		String input = sc.nextLine();

		try {
			String[] data = input.split(":");

			String flightNumber = data[0];
			String flightName = data[1];
			int passengerCount = Integer.parseInt(data[2]);
			double fuelLevel = Double.parseDouble(data[3]);

			FlightUtil util = new FlightUtil();

			util.validateFlightNumber(flightNumber);
			util.validateFlightName(flightName);
			util.validatePassengerCount(passengerCount, flightName);

			double fuelRequired = util.calculateFuelToFillTank(flightName, fuelLevel);

			System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

		} catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
