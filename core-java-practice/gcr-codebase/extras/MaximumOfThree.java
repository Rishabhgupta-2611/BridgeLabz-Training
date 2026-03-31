import java.util.*;

public class MaximumOfThree {

	static int findMaximum(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= a && b >= c)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter first number: ");
		int a = sc.nextInt();

		System.out.print("Enter second number: ");
		int b = sc.nextInt();

		System.out.print("Enter third number: ");
		int c = sc.nextInt();

		int max = findMaximum(a, b, c);
		System.out.println("Maximum number is: " + max);

		sc.close();
	}
}
