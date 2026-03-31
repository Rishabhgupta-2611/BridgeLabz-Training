
public class CartItem {

	String itemName;
	double price;
	int quantity;

	CartItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	void addItem(int qty) {
		quantity = quantity + qty;
		System.out.println("Added " + qty + " of " + itemName + " to the cart.");
	}

	void removeItem(int qty) {
		quantity = quantity - qty;
		System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
	}

	void displayTotalCost() {
		System.out.println("Total cost: $" + (price * quantity));
	}

	public static void main(String[] args) {
		CartItem cart = new CartItem("Laptop", 999.99, 1);

		System.out.println("Item: Laptop, Price: $999.99, Quantity: 1");
		cart.addItem(2);
		cart.removeItem(1);
		cart.displayTotalCost();
	}
}
