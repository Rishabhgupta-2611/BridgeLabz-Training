package orderManagementSystem;

public class Main {
	public static void main(String[] args) {

		Product product = new Product(101, "Wireless Headphones", 2999);
		Customer customer = new Customer(1, "Rishabh");

		Order order = new Order(product, customer);

		Payment paymentMethod = new UPI(); // Polymorphism
		order.placeOrder(paymentMethod);

		order.trackOrder();
		order.cancelOrder();
		order.trackOrder();
	}
}
