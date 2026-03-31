
public class MathUtility {

	static long factorial(int n) {
		if (n < 0) {
			return -1;
		}
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);

		if (a == 0 && b == 0) {
			return 0;
		}

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	static int fibonacci(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int a = 0, b = 1;
		for (int i = 2; i <= n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}

	public static void main(String[] args) {

		System.out.println("Factorial Tests:");
		System.out.println(factorial(5));
		System.out.println(factorial(0));
		System.out.println(factorial(-3));

		System.out.println("Prime Tests:");
		System.out.println(isPrime(7));
		System.out.println(isPrime(1));
		System.out.println(isPrime(-5));

		System.out.println("GCD Tests:");
		System.out.println(gcd(12, 18));
		System.out.println(gcd(0, 5));
		System.out.println(gcd(-4, -8));

		System.out.println("Fibonacci Tests:");
		System.out.println(fibonacci(7));
		System.out.println(fibonacci(0));
		System.out.println(fibonacci(-2));
	}
}
