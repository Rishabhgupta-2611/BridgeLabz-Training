package libraryManagementSystem;

class StaffMember extends Member {

	public StaffMember(String id, String name) {
		super(id, name);
	}

	@Override
	public double calculateFine(int lateDays) {
		return lateDays * 5; // ₹5 per day
	}
}
