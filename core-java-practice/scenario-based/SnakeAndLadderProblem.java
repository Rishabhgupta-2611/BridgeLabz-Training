import java.util.*;

public class SnakeAndLadderProblem {
	public static int rollDie() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public static int choice(int n) {
		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to Snake and Ladder Game");
		final int WINNING_POSITION = 100;
		int player_1 = 0;
		int player_2 = 0;
		Random random = new Random();
		while (player_1 < WINNING_POSITION && player_2 < WINNING_POSITION) {
			// Player 1 turn
			boolean player1_chance = true;
			while (player1_chance) {
				int dieRoll1 = rollDie();
				int option1 = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
				player_1 = player_1 + choice(option1) * dieRoll1;
				if (player_1 < 0) {
					player_1 = 0;
				} else if (player_1 > WINNING_POSITION) {
					player_1 -= dieRoll1; // Revert move if exceeds winning position
				}
				if (option1 != 1) {
					player1_chance = false;
				} else {
					System.out.println("player 1 gets Ladder so it roll dice again");
				}
			}
			// Player 2 turn
			boolean player2_chance = true;
			while (player2_chance) {
				int dieRoll2 = rollDie();
				int option2 = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
				player_2 = player_2 + choice(option2) * dieRoll2;
				if (player_2 < 0) {
					player_2 = 0;
				} else if (player_2 > WINNING_POSITION) {
					player_2 -= dieRoll2;
				}
				if (option2 != 1) {
					player2_chance = false;
				} else {
					System.out.println("player 2 gets Ladder so it roll dice again");
				}
			}
			String temp = "Player 1 position: " + player_1 + " | Player 2 position: " + player_2;
			for (char i : temp.toCharArray()) {
				System.out.print(i);
				// Thread.sleep(4);
			}
			System.out.println("");
			if (player_1 == WINNING_POSITION) {
				System.out.println("Player 1 wins!");
				return;
			} else if (player_2 == WINNING_POSITION) {
				System.out.println("Player 2 wins!");
				return;
			}
		}
	}
}