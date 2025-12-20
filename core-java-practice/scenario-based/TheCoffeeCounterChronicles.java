import java.util.Scanner;

public class TheCoffeeCounterChronicles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final double GST_RATE = 0.05; // 5% GST

		System.out.println("------- Ravi's Café Billing System -------");
		System.out.println("Type 'Exit' to Stop");

		while (true) {
			System.out.print("Enter Customer Name: ");
			String customerName = sc.nextLine();

			if (customerName.equalsIgnoreCase("Exit")) {
				System.out.println("Thanks For Visiting Ravi's Café ");
				break;
			}

			System.out.println("Hello " + customerName + " Please Choose Your Coffee Type:");

			// Types of Coffee list
			System.out.println("1. Espresso   - ₹100");
			System.out.println("2. Latte      - ₹150");
			System.out.println("3. Cappuccino - ₹180");
			System.out.println("4. Mocha      - ₹200");
			System.out.println("5. Americano  - ₹250");

			// Checking Whether User Enter's Valid Choose or not?
			System.out.print("Please Enter Your Choose (1-5): ");
			int coffeeChoice = 0;
			if (sc.hasNextInt()) {
				coffeeChoice = sc.nextInt();
			} else {
				System.out.println("Invalid Input! Please Enter A Number Between 1-5 ");
				sc.nextLine();
				continue;
			}

			// Checking Whether User Enter's Valid Quantity or not?
			System.out.print("Enter Quantity: ");
			int quantity = 0;
			if (sc.hasNextInt()) {
				quantity = sc.nextInt();
			} else {
				System.out.println("Invaild Quantity! Please Enter Valid Quantity");
				sc.nextLine();
				continue;
			}

			sc.nextLine();

			double unitPrice;
			String coffeeName;

			switch (coffeeChoice) {
			case 1:
				coffeeName = "Espresso";
				unitPrice = 100.0;
				break;

			case 2:
				coffeeName = "Latte";
				unitPrice = 150.0;
				break;

			case 3:
				coffeeName = "Cappuccino";
				unitPrice = 180.0;
				break;

			case 4:
				coffeeName = "Mocha";
				unitPrice = 200.0;
				break;

			case 5:
				coffeeName = "Americano";
				unitPrice = 250.0;
				break;

			default:
				System.out.println("Invalid coffee choice. Please try again!");
				continue;

			}

			double subTotal = unitPrice * quantity;
			double gstAmount = subTotal * GST_RATE;
			double grandTotal = subTotal + gstAmount;

			System.out.println("----- Bill for " + customerName + " -----");
			System.out.println("Coffee      : " + coffeeName);
			System.out.println("Unit Price  : ₹" + unitPrice);
			System.out.println("Quantity    : " + quantity);
			System.out.println("Subtotal    : ₹" + subTotal);
			System.out.println("GST (5%)    : ₹" + gstAmount);
			System.out.println("Grand Total : ₹" + grandTotal);
			System.out.println("------------------------------");

		}

		sc.close();

	}

}
