import java.util.*;

public class RockPaperScissors {

	// get computer choice
	static String computerChoice() {
		int r = (int) (Math.random() * 3);
		if (r == 0)
			return "rock";
		if (r == 1)
			return "paper";
		return "scissors";
	}

	// decide winner
	static String findWinner(String user, String comp) {
		if (user.equals(comp))
			return "Draw";

		if ((user.equals("rock") && comp.equals("scissors")) || (user.equals("paper") && comp.equals("rock"))
				|| (user.equals("scissors") && comp.equals("paper")))
			return "User";

		return "Computer";
	}

	// calculate stats
	static String[][] calculateStats(int userWins, int compWins, int games) {
		String[][] stats = new String[2][3];

		stats[0][0] = "User";
		stats[0][1] = String.valueOf(userWins);
		stats[0][2] = String.valueOf((userWins * 100) / games);

		stats[1][0] = "Computer";
		stats[1][1] = String.valueOf(compWins);
		stats[1][2] = String.valueOf((compWins * 100) / games);

		return stats;
	}

	// display stats
	static void displayStats(String[][] stats) {
		System.out.println("\nPlayer\tWins\tWin %");
		for (int i = 0; i < stats.length; i++) {
			System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of games: ");
		int games = sc.nextInt();

		int userWins = 0;
		int compWins = 0;

		for (int i = 1; i <= games; i++) {
			System.out.print("\nEnter your choice (rock/paper/scissors): ");
			String user = sc.next().toLowerCase();

			String comp = computerChoice();
			String winner = findWinner(user, comp);

			System.out.println("Computer chose: " + comp);
			System.out.println("Winner: " + winner);

			if (winner.equals("User"))
				userWins++;
			else if (winner.equals("Computer"))
				compWins++;
		}

		String[][] stats = calculateStats(userWins, compWins, games);
		displayStats(stats);

		sc.close();
	}
}
