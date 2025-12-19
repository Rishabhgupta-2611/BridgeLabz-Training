import java.util.*;

public class FactorialWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter A Number: ");
		int n = sc.nextInt();

		if (n > 0) { // Check Positive Number
			int factorial = 1; // Compute factorial using while-loop
			int i = 1;
			while (i <= n) {
				factorial *= i;
				i++;
			}

			System.out.println("Factorial of " + n + " is " + factorial);
		} else {
			System.out.println("Enter A Positive Number Only!");
		}

		sc.close();
	}
}
