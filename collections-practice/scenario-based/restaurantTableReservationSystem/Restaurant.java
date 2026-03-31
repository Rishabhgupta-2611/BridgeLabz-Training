package restaurantTableReservationSystem;

import java.util.*;

public class Restaurant {

	private Map<Integer, Table> tables = new HashMap<>();
	private List<Reservation> reservations = new ArrayList<>();

	public void addTable(Table table) {
		tables.put(table.getTableNumber(), table);
	}

	public void reserveTable(int tableNumber, String timeSlot, String customerName)
			throws TableAlreadyReservedException {

		for (Reservation r : reservations) {
			if (r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot)) {
				throw new TableAlreadyReservedException("Table already reserved for the given time slot");
			}
		}

		reservations.add(new Reservation(tableNumber, timeSlot, customerName));
		System.out.println("Table reserved successfully");
	}

	public void cancelReservation(int tableNumber, String timeSlot) {
		reservations.removeIf(r -> r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot));

		System.out.println("Reservation cancelled");
	}

	public void showAvailableTables(String timeSlot) {
		System.out.println("Available tables for " + timeSlot);

		for (Table table : tables.values()) {
			boolean reserved = false;

			for (Reservation r : reservations) {
				if (r.getTableNumber() == table.getTableNumber() && r.getTimeSlot().equals(timeSlot)) {
					reserved = true;
					break;
				}
			}

			if (!reserved) {
				System.out.println("Table " + table.getTableNumber() + " Capacity " + table.getCapacity());
			}
		}
	}
}
