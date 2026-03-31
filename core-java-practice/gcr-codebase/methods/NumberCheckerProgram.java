import java.util.*;

public class NumberCheckerProgram {

	public static int countDigits(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num /= 10;
		}
		return count;
	}

	public static int[] storeDigits(int num, int count) {
		int digits[] = new int[count];
		int index = count - 1;

		while (num != 0) {
			digits[index--] = num % 10;
			num /= 10;
		}
		return digits;
	}

	public static int sumOfDigits(int[] digits) {
		int sum = 0;
		for (int d : digits) {
			sum += d;
		}
		return sum;
	}

	public static int sumOfSquaresOfDigits(int[] digits) {
		int sum = 0;
		for (int d : digits) {
			sum += Math.pow(d, 2);
		}
		return sum;
	}

	public static boolean isHarshad(int number, int[] digits) {
		int sum = sumOfDigits(digits);
		return number % sum == 0;
	}

	public static int[][] digitFrequency(int[] digits) {
		int[][] freq = new int[10][2];

		for (int i = 0; i < 10; i++) {
			freq[i][0] = i;
			freq[i][1] = 0;
		}

		for (int d : digits) {
			freq[d][1]++;
		}
		return freq;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int count = countDigits(num);
		int[] digits = storeDigits(num, count);

		System.out.println("Number of digits: " + count);

		System.out.print("Digits: ");
		for (int d : digits) {
			System.out.print(d + " ");
		}
		System.out.println();

		int sum = sumOfDigits(digits);
		System.out.println("Sum of digits: " + sum);

		int sumSquares = sumOfSquaresOfDigits(digits);
		System.out.println("Sum of squares of digits: " + sumSquares);

		System.out.println("Is Harshad Number: " + isHarshad(num, digits));

		int[][] frequency = digitFrequency(digits);
		System.out.println("Digit Frequency:");
		System.out.println("Digit  Frequency");
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i][1] > 0) {
				System.out.println(frequency[i][0] + "      " + frequency[i][1]);
			}
		}
		sc.close();
	}

}
