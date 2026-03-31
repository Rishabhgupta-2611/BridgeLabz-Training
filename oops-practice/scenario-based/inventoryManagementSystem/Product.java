package inventoryManagementSystem;

public class Product {
	private int id;
	private String name;
	private double price;
	private int qty;

	Product(int id, String name, double price, int qty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public int getProductId() {
		return id;
	}

	public String getProductName() {
		return name;
	}

	public double getProductPrice() {
		return price;
	}

	public int getQuantity() {
		return qty;
	}

	public void updateStock(int qty) throws OutOfStockException {
		if (qty < 0 && qty + qty < 0) {
			throw new OutOfStockException("Out of stock for " + name);
		}
		qty += qty;
	}

	public void displayProduct() {
		System.out.println("Product Id: " + id);
		System.out.println("Product Name: " + name);
		System.out.println("Product Price: " + price);
		System.out.println("Product Quantity: " + qty);
	}

}
