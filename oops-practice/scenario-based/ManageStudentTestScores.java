import java.util.*;

public class ManageStudentTestScores {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int n = input.nextInt();
		int scores[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			while (true) {
				System.out.print("Enter score for student " + (i + 1) + ": ");
				if (input.hasNextInt()) {
					int score = input.nextInt();
					if (score >= 0) {

						scores[i] = score;

						sum += score;
						break;
					} else {

						System.out.println("Score cannot be negative");
					}
				} else {
					System.out.println("Invalid input");
					break;
				}
			}
		}

		double average = (double) sum / n;
		int highest = scores[0];
		int lowest = scores[0];

		for (int score : scores) {
			if (score > highest)
				highest = score;
			if (score < lowest)
				lowest = score;
		}

		System.out.println("Average Score: " + average);
		System.out.println("Highest Score: " + highest);
		System.out.println("Lowest Score: " + lowest);
		System.out.println("Scores above average:");
		for (int score : scores) {
			if (score > average) {
				System.out.print(score + " ");
			}
		}

		input.close();
	}
}