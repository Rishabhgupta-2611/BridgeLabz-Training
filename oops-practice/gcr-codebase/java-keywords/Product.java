
public class Product {

	private static double discount = 10.0;

	public static double updateDiscount(double newDiscount) {
		return discount = newDiscount;
	}

	private final String productID;
	private String productName;
	private double price;
	private int quantity;

	Product(String productID, String productName, double price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public void displayDetails() {
		if (this instanceof Product) {
			System.out.println("Product ID: " + productID);
			System.out.println("Product Name: " + productName);
			System.out.println("Price: $" + price);
			System.out.println("Quantity: " + quantity);
			System.out.println("Discount: " + discount + "%");
			double discountPrice = price - (price * discount / 100);
			System.out.println("Price after Discount: $" + discountPrice);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public static void main(String[] args) {
		Product p1 = new Product("P001", "Laptop", 1200.0, 5);
		Product p2 = new Product("P002", "Smartphone", 800.0, 10);
		p1.displayDetails();
		p2.displayDetails();
	}

}
