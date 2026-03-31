package orderManagementSystem;

class Wallet implements Payment {
	public void pay(double amount) throws PaymentFailedException {
		if (amount > 1000) {
			throw new PaymentFailedException("Wallet Limit Exceeded");
		} else {
			System.out.println("Wallet Payment Successfully Done! " + amount);
		}
	}
}
