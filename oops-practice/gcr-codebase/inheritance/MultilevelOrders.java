import java.time.LocalDate;

class Order {
	String orderId;
	LocalDate orderDate;

	Order(String orderId, LocalDate orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	String getOrderStatus() {
		return "Order placed";
	}
}

class ShippedOrder extends Order {
	String trackingNumber;

	ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}

	@Override
	String getOrderStatus() {
		return "Shipped (Tracking: " + trackingNumber + ")";
	}
}

class DeliveredOrder extends ShippedOrder {
	LocalDate deliveryDate;

	DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
		super(orderId, orderDate, trackingNumber);
		this.deliveryDate = deliveryDate;
	}

	@Override
	String getOrderStatus() {
		return "Delivered on " + deliveryDate;
	}
}

public class MultilevelOrders {
	public static void main(String[] args) {
		Order o = new Order("O100", LocalDate.now());
		ShippedOrder s = new ShippedOrder("O101", LocalDate.now().minusDays(2), "TRK123");
		DeliveredOrder d = new DeliveredOrder("O102", LocalDate.now().minusDays(5), "TRK999",
				LocalDate.now().minusDays(1));

		System.out.println(o.getOrderStatus());
		System.out.println(s.getOrderStatus());
		System.out.println(d.getOrderStatus());
	}
}