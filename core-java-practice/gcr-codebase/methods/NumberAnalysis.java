import java.util.Scanner;

public class NumberAnalysis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numbers = new int[5];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		for (int i = 0; i < numbers.length; i++) {
			if (isPositive(numbers[i])) {
				if (isEven(numbers[i])) {
					System.out.println("Positive Even");
				} else {
					System.out.println("Positive Odd");
				}
			} else {
				System.out.println("Negative");
			}
		}

		int result = compare(numbers[0], numbers[numbers.length - 1]);

		if (result == 1) {
			System.out.println("First element is greater than last element");
		} else if (result == 0) {
			System.out.println("First element is equal to last element");
		} else {
			System.out.println("First element is less than last element");
		}
		sc.close();
	}

	static boolean isPositive(int num) {
		return num >= 0;
	}

	static boolean isEven(int num) {
		return num % 2 == 0;
	}

	static int compare(int num1, int num2) {
		if (num1 > num2) {
			return 1;
		} else if (num1 == num2) {
			return 0;
		} else {
			return -1;
		}
	}
}
