import java.util.Scanner;

public class RohanLibraryReminderApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int finePerDay = 5;

		System.out.println("Rohan's Library Reminder App - Fine Calculator");

		for (int i = 1; i <= 5; i++) {
			System.out.println("Book #" + i);

			System.out.print("Enter due date (day of month): ");
			int dueDate = sc.nextInt();

			System.out.print("Enter return date (day of month): ");
			int returnDate = sc.nextInt();

			int fine = 0;
			if (returnDate > dueDate) {
				fine = (returnDate - dueDate) * finePerDay;
			}

			System.out.println("Fine for Book #" + i + ": ₹" + fine);
		}

		System.out.println("All books processed. Thank you!");
		sc.close();
	}
}
