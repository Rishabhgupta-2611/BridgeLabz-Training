import java.util.Scanner;

public class SumNaturalNumbersRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n <= 0) {
			System.out.println("Not a natural number");
			return;
		}

		int recursiveSum = sumRecursive(n);
		int formulaSum = sumFormula(n);

		System.out.println(recursiveSum);
		System.out.println(formulaSum);

		if (recursiveSum == formulaSum) {
			System.out.println("Both results are correct");
		} else {
			System.out.println("Results are not equal");
		}

	}

	static int sumRecursive(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sumRecursive(n - 1);
	}

	static int sumFormula(int n) {
		return n * (n + 1) / 2;
	}
}
