import java.util.*;

public class NumberGuessingGame {

	public static int generateGuess(int low, int high) {
		Random rand = new Random();
		return rand.nextInt(high - low + 1) + low;
	}

	public static String getFeedback(Scanner sc) {
		System.out.print("Enter feedback (high / low / correct): ");
		return sc.nextLine();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int low = 1;
		int high = 100;
		boolean guessed = false;

		System.out.println("Think of a number between 1 and 100.");

		while (!guessed) {
			int guess = generateGuess(low, high);
			System.out.println("Computer guess: " + guess);

			while (true) { // feedback loop
				String feedback = getFeedback(sc);

				if (feedback.equalsIgnoreCase("correct")) {
					System.out.println("Hurrah!... Computer guessed the number correctly!");
					guessed = true;
					break;
				} else if (feedback.equalsIgnoreCase("high")) {
					high = guess - 1;
					break;
				} else if (feedback.equalsIgnoreCase("low")) {
					low = guess + 1;
					break;
				} else {
					System.out.println("Invalid sc, try again.");
					// no new guess, feedback asked again
				}
			}
		}

		sc.close();
	}
}
