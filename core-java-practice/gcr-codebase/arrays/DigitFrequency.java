import java.util.Scanner;

public class DigitFrequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		long number = sc.nextLong();

		int[] digits = new int[20];
		int count = 0;
		long temp = number;

		while (temp != 0) {
			digits[count] = (int) (temp % 10);
			temp /= 10;
			count++;
		}
		int[] freq = new int[10];

		for (int i = 0; i < count; i++) {
			freq[digits[i]]++;
		}
		System.out.println("Digit Frequency:");
		for (int i = 0; i < 10; i++) {
			if (freq[i] > 0) {
				System.out.println(i + ": " + freq[i]);
			}
		}

		sc.close();
	}
}
