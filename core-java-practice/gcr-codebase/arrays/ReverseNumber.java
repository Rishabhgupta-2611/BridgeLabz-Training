import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();

		boolean isNegative = number < 0;
		number = Math.abs(number);

		int temp = number;
		int count = 0;
		while (temp > 0) {
			temp /= 10;
			count++;
		}

		int[] digits = new int[count];
		temp = number;
		for (int i = count - 1; i >= 0; i--) {
			digits[i] = temp % 10;
			temp /= 10;
		}

		int[] reversed = new int[count];
		for (int i = 0; i < count; i++) {
			reversed[i] = digits[count - 1 - i];
		}

		System.out.print("Reversed number: ");
		if (isNegative) {
			System.out.print("-");
		}
		for (int digit : reversed) {
			System.out.print(digit);
		}

		sc.close();
	}
}
