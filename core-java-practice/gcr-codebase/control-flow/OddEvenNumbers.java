import java.util.*;

public class OddEvenNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();

		if (number > 0) { // Check for natural number (positive number > 0)
			for (int i = 1; i <= number; i++) {
				if (i % 2 == 0) {
					System.out.println(i + " is even number");
				} else {
					System.out.println(i + " is odd number");
				}
			}
		} else {
			System.out.println("Enter a positive number only!");
		}

		sc.close();
	}
}
