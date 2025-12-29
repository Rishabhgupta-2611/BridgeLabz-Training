import java.util.*;

public class FibonacciSequence {

	public static void Fibonacci(int n) {
		int a = 0, b = 1;

		System.out.print("Fibonacci Series: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(a + " ");
			int temp = a + b;
			a = b;
			b = temp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of terms: ");
		int n = sc.nextInt();

		Fibonacci(n);
		sc.close();
	}
}
