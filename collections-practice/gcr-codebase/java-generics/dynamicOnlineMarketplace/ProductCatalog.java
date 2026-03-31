package dynamicOnlineMarketplace;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog {

	private List<Product<? extends Category>> products = new ArrayList<>();

	public void addProduct(Product<? extends Category> product) {
		products.add(product);
	}

	public void displayProducts() {
		for (Product<? extends Category> product : products) {
			System.out.println(
					product.getName() + " | " + product.getCategory().getCategoryName() + " | ₹" + product.getPrice());
		}
	}
}
