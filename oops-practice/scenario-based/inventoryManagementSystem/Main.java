package inventoryManagementSystem;

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();

		Product p1 = new Product(100, "Keyboard", 600, 1);
		Product p2 = new Product(101, "Mouse", 1100, 2);

		inventory.addProduct(p1);
		inventory.addProduct(p2);

		inventory.viewInventory();

		System.out.println("\n Updating Stock");
		inventory.updateProductStock(p1, -6);
		inventory.updateProductStock(p2, -5);

		inventory.viewInventory();
	}

}
