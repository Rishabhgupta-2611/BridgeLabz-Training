import java.util.Scanner;

public class MetroSmartCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Delhi Metro Smart Card System ===");

		double balance = 200.0;
		char choice = 'y';

		while (balance > 0 && (choice == 'y' || choice == 'Y')) {
			System.out.println("Current balance: Rs " + balance);
			System.out.print("Enter travel distance in km: ");
			double distance = sc.nextDouble();
			double fare = (distance <= 5) ? 20.0 : 40.0; // 5 km -> Rs 20 more than 5 km -> Rs 40

			if (fare > balance) {
				System.out.println("Insufficient balance for this trip.");
				break;
			}

			balance -= fare; // deduct fare
			System.out.println("Fare charged: Rs " + fare);
			System.out.println("Remaining balance: Rs " + balance);

			if (balance <= 0) {
				System.out.println("Balance exhausted. Cannot travel further.");
				break;
			}

			System.out.print("Do you want to travel again? (y/n): ");
			choice = sc.next().charAt(0);
			System.out.println();
		}

		System.out.println("Thank you for using Delhi Metro Smart Card.");
		sc.close();
	}
}
