import java.util.*;

// Interface
interface Taxable {
	double calculateTax();

	void getTaxDetails();
}

// Abstract class
abstract class Product {

	private int productID;
	private String name;
	private double price;

	public Product(int productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}

	// Encapsulation (getters/setter)
	public int getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Abstract method
	abstract double calculateDiscount();

	void displayDetails() {
		System.out.println("Product ID    : " + productID);
		System.out.println("Product Name  : " + name);
		System.out.println("Base Price    : " + price);
	}
}

// Electronics
class Electronics extends Product implements Taxable {

	public Electronics(int productID, String name, double price) {
		super(productID, name, price);
	}

	public double calculateDiscount() {
		return getPrice() * 0.20; // Discount 20 percent
	}

	public double calculateTax() {
		return getPrice() * 0.18; // Discount 18 percent
	}

	public void getTaxDetails() {
		System.out.println("Tax Type      : GST 18%");
	}
}

// Clothing
class Clothing extends Product implements Taxable {

	public Clothing(int productId, String name, double price) {
		super(productId, name, price);
	}

	public double calculateDiscount() {
		return getPrice() * 0.20; // Discount 20 percent
	}

	public double calculateTax() {
		return getPrice() * 0.12; // Discount 18 percent
	}

	public void getTaxDetails() {
		System.out.println("Tax Type      : GST 12%");
	}
}

// Groceries (No tax)
class Groceries extends Product {

	public Groceries(int productId, String name, double price) {
		super(productId, name, price);
	}

	public double calculateDiscount() {
		return getPrice() * 0.05;
	}
}

// Main class
public class Ecommerce {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();

		Product p1 = new Electronics(101, "Laptop", 60000);
		Product p2 = new Clothing(102, "Jacket", 4000);
		Product p3 = new Groceries(103, "Rice Bag", 1200);

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);

		// Polymorphism using list
		for (Product prod : productList) {

			System.out.println("---------------------------");
			prod.displayDetails();

			double tax = 0;
			if (prod instanceof Taxable) {
				Taxable t = (Taxable) prod;
				tax = t.calculateTax();
				t.getTaxDetails();
			} else {
				System.out.println("Tax Type      : No Tax");
			}

			double discount = prod.calculateDiscount();
			double finalPrice = prod.getPrice() + tax - discount;

			System.out.println("Discount      : " + discount);
			System.out.println("Tax Amount    : " + tax);
			System.out.println("Final Price   : " + finalPrice);
		}
	}
}