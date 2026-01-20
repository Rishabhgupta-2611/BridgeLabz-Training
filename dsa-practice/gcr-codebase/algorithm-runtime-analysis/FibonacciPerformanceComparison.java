
public class FibonacciPerformanceComparison {

	public static int fibonacciRecursive(int n) {
		if (n <= 1)
			return n;
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static int fibonacciIterative(int n) {
		if (n <= 1)
			return n;

		int a = 0, b = 1, sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}

	public static void main(String[] args) {

		int[] values = { 10, 30, 50 };

		for (int n : values) {

			long start, end;

			// Recursive
			start = System.nanoTime();
			if (n <= 30) // prevent long execution
				fibonacciRecursive(n);
			end = System.nanoTime();
			System.out.println("Recursive Fibonacci (" + n + "): " + (end - start) / 1_000_000 + " ms");

			// Iterative
			start = System.nanoTime();
			fibonacciIterative(n);
			end = System.nanoTime();
			System.out.println("Iterative Fibonacci (" + n + "): " + (end - start) / 1_000_000 + " ms");

			System.out.println("----------------------------");
		}
	}
}
