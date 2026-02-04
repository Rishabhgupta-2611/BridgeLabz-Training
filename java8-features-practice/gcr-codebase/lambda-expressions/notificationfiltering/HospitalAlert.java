package notificationfiltering;

import java.util.*;
import java.util.function.Predicate;

public class HospitalAlert {

	public static void main(String[] args) {

		List<Alert> alerts = Arrays.asList(new Alert("Emergency", "Patient heart rate critical"),
				new Alert("Lab", "Blood test report ready"), new Alert("Medicine", "Time to take insulin"),
				new Alert("Appointment", "Doctor visit at 5 PM"));

		Predicate<Alert> emergencyOnly = alert -> alert.type.equals("Emergency");

		Predicate<Alert> labAndMedicine = alert -> alert.type.equals("Lab") || alert.type.equals("Medicine");

		System.out.println("Emergency Alerts:");
		filterAlerts(alerts, emergencyOnly);

		System.out.println("\nLab & Medicine Alerts:");
		filterAlerts(alerts, labAndMedicine);
	}

	static void filterAlerts(List<Alert> alerts, Predicate<Alert> condition) {
		for (Alert alert : alerts) {
			if (condition.test(alert)) {
				System.out.println(alert);
			}
		}
	}
}
