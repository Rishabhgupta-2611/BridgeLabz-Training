import java.util.Scanner;

public class FactorsArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		int[] factors = findFactors(number);

		int sum = findSum(factors);
		long product = findProduct(factors);
		double sumOfSquares = findSumOfSquares(factors);

		for (int f : factors) {
			System.out.print(f + " ");
		}
		System.out.println();
		System.out.println(sum);
		System.out.println(sumOfSquares);
		System.out.println(product);
		sc.close();
	}

	static int[] findFactors(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}

		int[] arr = new int[count];
		int index = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				arr[index++] = i;
			}
		}
		return arr;
	}

	static int findSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	static long findProduct(int[] arr) {
		long product = 1;
		for (int i : arr) {
			product *= i;
		}
		return product;
	}

	static double findSumOfSquares(int[] arr) {
		double sum = 0;
		for (int i : arr) {
			sum += Math.pow(i, 2);
		}
		return sum;
	}
}
