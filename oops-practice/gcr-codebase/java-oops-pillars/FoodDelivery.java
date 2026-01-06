interface Discountable {
	void applyDiscount(double percentage);

	void getDiscountDetails();
}

abstract class FoodItem implements Discountable {
	private String ItemName;
	private double price;
	private int quantity;

	public FoodItem(String itemName, double price, int quantity) {
		this.ItemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemName() {
		return ItemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public abstract void calculateTotalPrice();

	public abstract void getItemDetails();

	public void applyDiscount(double percentage) {
		double discountAmount = (price * percentage) / 100;
		price -= discountAmount;
		System.out.println("Discount of " + percentage + "% applied.");
	}

	public void getDiscountDetails() {
		System.out.println("Current price after discount: " + price);
	}
}

class VegItem extends FoodItem {
	private boolean isOrganic;

	public VegItem(String itemName, double price, int quantity, boolean isOrganic) {
		super(itemName, price, quantity);
		this.isOrganic = isOrganic;
	}

	@Override
	public void calculateTotalPrice() {
		System.out.print("Calculating total price for Veg Item : ");
		System.out.println(getPrice() * getQuantity());
	}

	@Override
	public void getItemDetails() {
		System.out.println("Veg Item Details:");
		System.out.println("Item Name: " + getItemName());
		System.out.println("Price: " + getPrice());
		System.out.println("Quantity: " + getQuantity());
		System.out.println("Is Organic: " + isOrganic);
		System.out.println("----------------------------");
	}

}

class NonVegItem extends FoodItem {
	private String meatType;

	public NonVegItem(String itemName, double price, int quantity, String meatType) {
		super(itemName, price, quantity);
		this.meatType = meatType;
	}

	@Override
	public void calculateTotalPrice() {
		System.out.print("Calculating total price for Non-Veg Item : ");
		System.out.println(getPrice() * getQuantity());
	}

	@Override
	public void getItemDetails() {
		System.out.println("Non-Veg Item Details:");
		System.out.println("Item Name: " + getItemName());
		System.out.println("Price: " + getPrice());
		System.out.println("Quantity: " + getQuantity());
		System.out.println("Meat Type: " + meatType);
		System.out.println("----------------------------");
	}
}

public class FoodDelivery {
	public static void main(String[] args) {
		VegItem vegItem = new VegItem("Paneer Curry", 150.0, 2, true);
		vegItem.getItemDetails();
		vegItem.calculateTotalPrice();
		vegItem.applyDiscount(10);
		vegItem.getDiscountDetails();

		NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 250.0, 1, "Chicken");
		nonVegItem.getItemDetails();
		nonVegItem.calculateTotalPrice();
		nonVegItem.applyDiscount(5);
		nonVegItem.getDiscountDetails();
	}
}
