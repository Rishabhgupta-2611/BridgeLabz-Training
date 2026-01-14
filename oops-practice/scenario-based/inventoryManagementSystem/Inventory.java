package inventoryManagementSystem;

import java.util.*;

class Inventory implements AlertService {

	private List<Product> products = new ArrayList<>();
	private static final int LOW_STOCK_LIMIT = 5;

	// Add product
	public void addProduct(Product product) {
		products.add(product);
		System.out.println("Product added: " + product.getProductName());
	}

	// Update stock
	public void updateProductStock(Product product, int qty) {
		try {
			product.updateStock(qty);
			System.out.println("Stock updated for " + product.getProductName());
		} catch (OutOfStockException e) {
			System.out.println(e.getMessage());
		}
		checkLowStock(product);
	}

	// View inventory
	public void viewInventory() {
		System.out.println("\n--- Inventory ---");
		for (Product p : products) {
			p.displayProduct();
		}
	}

	// Low stock alert
	public void checkLowStock(Product product) {
		if (product.getQuantity() <= LOW_STOCK_LIMIT) {
			System.out.println("⚠ Low Stock Alert: " + product.getProductName());
		}
	}
}
