import java.util.Scanner;

public class MaximumHandshakes {
	static int combination(int n) {
		int handshakes = (n * (n - 1)) / 2; // Formula:Combination = (n * (n - 1)) / 2
		return handshakes;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		int numberOfCombination = combination(numberOfStudents);
		System.out.println("The number of possible handshakes: " + numberOfCombination);
		sc.close();

	}

}
