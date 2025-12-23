import java.util.Scanner;

public class DeckOfCards {

	public static String[] initializeDeck(String[] suits, String[] ranks) {

		int numOfCards = suits.length * ranks.length;
		String[] deck = new String[numOfCards];

		int index = 0;
		for (String suit : suits) {
			for (String rank : ranks) {
				deck[index++] = rank + " of " + suit;
			}
		}
		return deck;
	}

	public static String[] shuffleDeck(String[] deck) {

		int n = deck.length;

		for (int i = 0; i < n; i++) {
			int randomCardNumber = i + (int) (Math.random() * (n - i));
			String temp = deck[i];
			deck[i] = deck[randomCardNumber];
			deck[randomCardNumber] = temp;
		}
		return deck;
	}

	public static String[][] distributeCards(String[] deck, int n, int players) {

		if (n % players != 0) {
			System.out.println("Cards cannot be evenly distributed.");
			return null;
		}

		int cardsPerPlayer = n / players;
		String[][] playerCards = new String[players][cardsPerPlayer];

		int cardIndex = 0;
		for (int i = 0; i < players; i++) {
			for (int j = 0; j < cardsPerPlayer; j++) {
				playerCards[i][j] = deck[cardIndex++];
			}
		}
		return playerCards;
	}

	public static void printPlayers(String[][] players) {

		for (int i = 0; i < players.length; i++) {
			System.out.println("\nPlayer " + (i + 1) + " cards:");
			for (int j = 0; j < players[i].length; j++) {
				System.out.println(players[i][j]);
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		String[] deck = initializeDeck(suits, ranks);
		deck = shuffleDeck(deck);

		System.out.print("Enter number of cards to distribute: ");
		int n = sc.nextInt();

		System.out.print("Enter number of players: ");
		int players = sc.nextInt();

		if (n > deck.length) {
			System.out.println("Not enough cards in the deck.");
		}

		String[][] playerCards = distributeCards(deck, n, players);

		if (playerCards != null) {
			printPlayers(playerCards);
		}

		sc.close();
	}
}
