package orderManagementSystem;

class UPI implements Payment {
	public void pay(double amount) throws PaymentFailedException {
		if (amount > 10000) {
			throw new PaymentFailedException("UPI Limit Exceeded");
		} else {
			System.out.println("UPI Payment Successfully Done! " + amount);
		}
	}
}
