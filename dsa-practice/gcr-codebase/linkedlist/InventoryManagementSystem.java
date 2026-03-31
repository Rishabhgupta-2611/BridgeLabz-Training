
class ItemNode {
	int itemId;
	String itemName;
	int quantity;
	double price;
	ItemNode next;

	ItemNode(int itemId, String itemName, int quantity, double price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}

class InventoryLinkedList {
	ItemNode head;

	void addAtBeginning(int id, String name, int qty, double price) {
		ItemNode newNode = new ItemNode(id, name, qty, price);
		newNode.next = head;
		head = newNode;
	}

	void addAtEnd(int id, String name, int qty, double price) {
		ItemNode newNode = new ItemNode(id, name, qty, price);

		if (head == null) {
			head = newNode;
			return;
		}

		ItemNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	void addAtPosition(int pos, int id, String name, int qty, double price) {
		if (pos == 1) {
			addAtBeginning(id, name, qty, price);
			return;
		}

		ItemNode temp = head;
		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Invalid position");
			return;
		}

		ItemNode newNode = new ItemNode(id, name, qty, price);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	void removeById(int id) {
		if (head == null) {
			System.out.println("Inventory empty");
			return;
		}

		if (head.itemId == id) {
			head = head.next;
			System.out.println("Item removed");
			return;
		}

		ItemNode temp = head;
		while (temp.next != null && temp.next.itemId != id) {
			temp = temp.next;
		}

		if (temp.next == null) {
			System.out.println("Item not found");
		} else {
			temp.next = temp.next.next;
			System.out.println("Item removed");
		}
	}

	void updateQuantity(int id, int newQty) {
		ItemNode temp = head;

		while (temp != null) {
			if (temp.itemId == id) {
				temp.quantity = newQty;
				System.out.println("Quantity updated");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Item not found");
	}

	void searchById(int id) {
		ItemNode temp = head;

		while (temp != null) {
			if (temp.itemId == id) {
				displayItem(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Item not found");
	}

	void searchByName(String name) {
		ItemNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.itemName.equalsIgnoreCase(name)) {
				displayItem(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("Item not found");
	}

	void calculateTotalValue() {
		ItemNode temp = head;
		double total = 0;

		while (temp != null) {
			total += temp.price * temp.quantity;
			temp = temp.next;
		}

		System.out.println("Total Inventory Value: ₹" + total);
	}

	void sortByName(boolean ascending) {
		for (ItemNode i = head; i != null; i = i.next) {
			for (ItemNode j = i.next; j != null; j = j.next) {
				if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0)
						|| (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
					swapData(i, j);
				}
			}
		}
	}

	void sortByPrice(boolean ascending) {
		for (ItemNode i = head; i != null; i = i.next) {
			for (ItemNode j = i.next; j != null; j = j.next) {
				if ((ascending && i.price > j.price) || (!ascending && i.price < j.price)) {
					swapData(i, j);
				}
			}
		}
	}

	void swapData(ItemNode a, ItemNode b) {
		int id = a.itemId;
		String name = a.itemName;
		int qty = a.quantity;
		double price = a.price;

		a.itemId = b.itemId;
		a.itemName = b.itemName;
		a.quantity = b.quantity;
		a.price = b.price;

		b.itemId = id;
		b.itemName = name;
		b.quantity = qty;
		b.price = price;
	}

	void displayAll() {
		ItemNode temp = head;
		while (temp != null) {
			displayItem(temp);
			temp = temp.next;
		}
	}

	void displayItem(ItemNode i) {
		System.out
				.println("ID: " + i.itemId + ", Name: " + i.itemName + ", Qty: " + i.quantity + ", Price: ₹" + i.price);
	}
}

public class InventoryManagementSystem {
	public static void main(String[] args) {

		InventoryLinkedList inventory = new InventoryLinkedList();

		inventory.addAtEnd(1, "Pen", 50, 10);
		inventory.addAtEnd(2, "Notebook", 30, 60);
		inventory.addAtBeginning(3, "Pencil", 100, 5);

		System.out.println("All Items:");
		inventory.displayAll();
		System.out.println("Update Quantity:");
		inventory.updateQuantity(2, 40);
		System.out.println("Search by Name:");
		inventory.searchByName("Pen");
		System.out.println("Total Value:");
		inventory.calculateTotalValue();
		System.out.println("Sort by Price (Ascending):");
		inventory.sortByPrice(true);
		inventory.displayAll();
	}
}
