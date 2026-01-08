import java.util.Scanner;

public class CafeteriaMenuApp {

	static void displayMenu(String[] items) {
		System.out.println("Cafeteria Menu:");
		for (int i = 0; i < items.length; i++) {
			System.out.println(i + " - " + items[i]);
		}
	}

	static String getItemByIndex(String[] items, int index) {
		if (index >= 0 && index < items.length) {
			return items[index];
		}
		return "Invalid selection";
	}

	public static void main(String[] args) {

		String[] menuItems = { "Veg Sandwich", "Cheese Burger", "Pasta", "Pizza Slice", "Fried Rice", "Noodles",
				"Samosa", "French Fries", "Cold Coffee", "Tea" };

		Scanner sc = new Scanner(System.in);

		displayMenu(menuItems);

		System.out.print("Enter item index to order: ");
		int choice = sc.nextInt();

		String selectedItem = getItemByIndex(menuItems, choice);
		System.out.println("You selected: " + selectedItem);

		sc.close();
	}
}
