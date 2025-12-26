import java.util.*;

public class NumberCheckerPerfect {

	public static int sumOfDivisors(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++)
			if (n % i == 0)
				sum += i;
		return sum;
	}

	public static boolean isPerfect(int n) {
		return sumOfDivisors(n) == n;
	}

	public static boolean isAbundant(int n) {
		return sumOfDivisors(n) > n;
	}

	public static boolean isDeficient(int n) {
		return sumOfDivisors(n) < n;
	}

	public static boolean isStrong(int n) {
		int temp = n, sum = 0;
		while (temp != 0) {
			sum += factorial(temp % 10);
			temp /= 10;
		}
		return sum == n;
	}

	public static int factorial(int n) {
		int f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();

		System.out.println("Is Perfect Number: " + isPerfect(number));
		System.out.println("Is Abundant Number: " + isAbundant(number));
		System.out.println("Is Deficient Number: " + isDeficient(number));
		System.out.println("Is Strong Number: " + isStrong(number));

		sc.close();
	}
}
