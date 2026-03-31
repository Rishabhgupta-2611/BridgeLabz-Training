package restaurantTableReservationSystem;

public class Main {
	public static void main(String[] args) {

		Restaurant restaurant = new Restaurant();

		restaurant.addTable(new Table(1, 4));
		restaurant.addTable(new Table(2, 2));
		restaurant.addTable(new Table(3, 6));

		try {
			restaurant.reserveTable(1, "7PM-8PM", "Rishabh");
			restaurant.reserveTable(2, "7PM-8PM", "Aman");
			restaurant.reserveTable(1, "7PM-8PM", "Rahul");
		} catch (TableAlreadyReservedException e) {
			System.out.println(e.getMessage());
		}

		restaurant.showAvailableTables("7PM-8PM");
		restaurant.cancelReservation(1, "7PM-8PM");
		restaurant.showAvailableTables("7PM-8PM");
	}
}
