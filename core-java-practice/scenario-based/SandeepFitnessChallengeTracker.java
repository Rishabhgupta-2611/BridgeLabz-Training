import java.util.Scanner;

public class SandeepFitnessChallengeTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Sandeep's Fitness Challenge - Week Push-up Tracker");

		int[] pushups = new int[7];
		int total = 0;
		int workoutDays = 0;

		for (int i = 0; i < 7; i++) {
			System.out.print("Enter push-ups for day " + (i + 1) + ": ");
			pushups[i] = sc.nextInt();
		}

		for (int p : pushups) {
			if (p == 0) {
				continue;
			}
			total += p;
			workoutDays++;
		}

		System.out.println("Total push-ups: " + total);

		if (workoutDays > 0) {
			double average = (double) total / workoutDays;
			System.out.println("Average push-ups per workout day: " + average);
		} else {
			System.out.println("No workout days this week!");
		}

		sc.close();
	}
}
