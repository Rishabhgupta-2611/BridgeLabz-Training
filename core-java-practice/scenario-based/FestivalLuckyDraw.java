import java.util.Scanner;

public class FestivalLuckyDraw {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Diwali Mela Lucky Draw ===");

		while (true) {
			System.out.print("Enter drawn number (or -1 to quit): ");
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input! Please enter a number");
				sc.next();
				continue;
			}
			int number = sc.nextInt();

			if (number == -1) {
				break;
			}

			if (number % 3 == 0 && number % 5 == 0) {
				System.out.println("You WIN a gift!");
			} else {
				System.out.println("No gift. Try again!");
			}

			System.out.println();
		}

		System.out.println("Lucky draw ended");
		sc.close();
	}
}
