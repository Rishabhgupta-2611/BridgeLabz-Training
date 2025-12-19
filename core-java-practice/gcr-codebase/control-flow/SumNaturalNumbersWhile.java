import java.util.*;

public class SumNaturalNumbersWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter A Natural Number: ");
		int n = sc.nextInt();
		if (n > 0) {
			int formula = n * (n + 1) / 2; // Formula: n*(n+1)/2

			int sum = 0; // While loop sum
			int i = 1;
			while (i <= n) {
				sum += i;
				i++;
			}
			System.out.println("Formula: " + formula);
			System.out.println("Loop: " + sum);
			System.out.println("Match: " + (formula == sum));
		} else {
			System.out.println("The number " + n + " is not a natural number");
		}
		sc.close();
	}
}
