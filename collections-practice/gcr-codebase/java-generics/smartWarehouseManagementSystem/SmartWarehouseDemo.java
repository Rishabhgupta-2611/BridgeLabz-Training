package smartWarehouseManagementSystem;

public class SmartWarehouseDemo {
	public static void main(String[] args) {

		Storage<Electronics> electronicsStorage = new Storage<>();
		electronicsStorage.addItem(new Electronics("Laptop"));
		electronicsStorage.addItem(new Electronics("Mobile"));

		Storage<Groceries> groceryStorage = new Storage<>();
		groceryStorage.addItem(new Groceries("Rice"));
		groceryStorage.addItem(new Groceries("Milk"));

		System.out.println("Electronics Items:");
		WarehouseUtil.displayItems(electronicsStorage.getItems());

		System.out.println("\nGrocery Items:");
		WarehouseUtil.displayItems(groceryStorage.getItems());
	}
}
