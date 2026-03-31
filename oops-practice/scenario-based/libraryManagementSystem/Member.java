package libraryManagementSystem;

class Member extends User implements FineCalculator {

	public Member(String userId, String name) {
		super(userId, name);
	}

	// Default fine (can be overridden)
	public double calculateFine(int lateDays) {
		return lateDays * 2; // ₹2 per day
	}
}
