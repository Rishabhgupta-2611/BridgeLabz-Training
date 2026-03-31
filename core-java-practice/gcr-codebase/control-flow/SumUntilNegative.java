import java.util.*;

public class SumUntilNegative {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double total = 0.0;

		System.out.print("Enter numbers (0 or negative to stop): ");

		while (true) {
			double number = sc.nextDouble();
			if (number <= 0) {
				break;
			}
			total += number;
			System.out.print("Enter next number (0 or negative to stop): ");
		}
		System.out.println("Total sum: " + total);
		sc.close();
	}
}
