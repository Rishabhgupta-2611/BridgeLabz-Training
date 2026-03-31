import java.util.Scanner;


public class NumberCheckerDigits {

	public static int countDigits(int num) {
		int c = 0;
		while (num != 0) {
			c++;
			num /= 10;
		}
		return c;
	}

	public static int[] storeDigits(int num, int count) {
		int[] arr = new int[count];
		for (int i = count - 1; i >= 0; i--) {
			arr[i] = num % 10;
			num /= 10;
		}
		return arr;
	}

	public static int[] reverseDigits(int[] digits) {
		int[] rev = new int[digits.length];
		for (int i = 0; i < digits.length; i++)
			rev[i] = digits[digits.length - 1 - i];
		return rev;
	}

	public static boolean areArraysEqual(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

	public static boolean isDuckNumber(int[] digits) {
		for (int d : digits)
			if (d != 0)
				return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = sc.nextInt();

		int count = countDigits(number);
		int[] digits = storeDigits(number, count);
		int[] reversed = reverseDigits(digits);

		System.out.println("Is Palindrome: " + areArraysEqual(digits, reversed));
		System.out.println("Is Duck Number: " + isDuckNumber(digits));

		sc.close();
	}
}
