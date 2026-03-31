import java.util.Scanner;

public class ElectionBoothManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int votesFor1 = 0; // BJP
		int votesFor2 = 0; // INC
		int votesFor3 = 0; // SP

		final int EXIT_CODE = -1;

		while (true) { // loop for multiple voters
			System.out.print("Enter voter age (or -1 to exit): ");
			int age = sc.nextInt();

			if (age == EXIT_CODE) { // Exit condition
				break;
			}

			if (age >= 18) {
				System.out.println("You are eligible to vote.");

				System.out.print("Enter your vote (1:BJP, 2:INC, or 3:SP): ");
				int vote = sc.nextInt();

				if (vote == 1) {
					votesFor1++;
				} else if (vote == 2) {
					votesFor2++;
				} else if (vote == 3) {
					votesFor3++;
				} else {
					System.out.println("Invalid vote. Vote not recorded.");
				}
			} else {
				System.out.println("You are NOT eligible to vote (age < 18).");
			}

			System.out.println(); // blank line between voters
		}

		// Final result
		System.out.println("Polling closed. Final vote count:");
		System.out.println("Candidate 1 (BJP): " + votesFor1 + " votes");
		System.out.println("Candidate 2 (INC): " + votesFor2 + " votes");
		System.out.println("Candidate 3 (SP): " + votesFor3 + " votes");

		// Find winner
		if (votesFor1 > votesFor2 && votesFor1 > votesFor3) {
			System.out.println("Winner: BJP");
		} else if (votesFor2 > votesFor1 && votesFor2 > votesFor3) {
			System.out.println("Winner: INC");
		} else if (votesFor3 > votesFor1 && votesFor3 > votesFor2) {
			System.out.println("Winner: SP");
		} else {
			System.out.println("Result: Tie between candidates.");
		}

		sc.close();
	}
}
