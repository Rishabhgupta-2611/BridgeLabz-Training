package hotelReservationSystem;

class Reservation {
	private Guest guest;
	private Room room;
	private int days;

	public Reservation(Guest guest, Room room, int days) {
		this.guest = guest;
		this.room = room;
		this.days = days;
	}

	public void checkIn() throws RoomNotAvailableException {
		if (!room.isAvailable()) {
			throw new RoomNotAvailableException("Room already booked!");
		}
		room.checkIn();
		System.out.println("Check-in successful for " + guest.getName());
	}

	public void checkOut() {
		room.checkOut();
		double bill = room.calculateBill(days);

		System.out.println("\n----- Invoice -----");
		System.out.println("Guest Name : " + guest.getName());
		System.out.println("Stay Days  : " + days);
		System.out.println("Total Bill : ₹" + bill);
		System.out.println("-------------------");
	}
}
