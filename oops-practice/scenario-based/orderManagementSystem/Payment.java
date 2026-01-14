package orderManagementSystem;

interface Payment {
	void pay(double amount) throws PaymentFailedException;
}
