package restaurantTableReservationSystem;

public class Reservation {
	private int tableNumber;
	private String timeSlot;
	private String customerName;

	public Reservation(int tableNumber, String timeSlot, String customerName) {
		this.tableNumber = tableNumber;
		this.timeSlot = timeSlot;
		this.customerName = customerName;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public String getCustomerName() {
		return customerName;
	}
}
