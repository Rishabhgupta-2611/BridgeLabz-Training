import java.util.*;

public class NumberChecker {

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

	public static boolean isDuckNumber(int[] digits) {
		for (int d : digits) {
			if (d != 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isArmstrong(int number, int[] digits) {
		int sum = 0;
		int power = digits.length;

		for (int d : digits) {
			sum += Math.pow(d, power);
		}
		return sum == number;
	}

	public static int[] findLargestAndSecondLargest(int[] digits) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int d : digits) {
			if (d > largest) {
				secondLargest = largest;
				largest = d;
			} else if (d > secondLargest && d != largest) {
				secondLargest = d;
			}
		}
		return new int[] { largest, secondLargest };
	}

	public static int[] findSmallestAndSecondSmallest(int[] digits) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int d : digits) {
			if (d < smallest) {
				secondSmallest = smallest;
				smallest = d;
			} else if (d < secondSmallest && d != smallest) {
				secondSmallest = d;
			}
		}
		return new int[] { smallest, secondSmallest };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int digitCount = countDigits(num);
		int digits[] = storeDigits(num, digitCount);

		System.out.println("Digit Count of a number given by you is: " + digitCount);

		for (int d : digits) {
			System.out.print(d + " ");
		}
		System.out.println();

		System.out.println("Is Duck Number: " + isDuckNumber(digits));
		System.out.println("Is Armstrong Number: " + isArmstrong(num, digits));

		int[] largest = findLargestAndSecondLargest(digits);
		System.out.println("Largest digit: " + largest[0]);
		System.out.println("Second Largest digit: " + largest[1]);

		int[] smallest = findSmallestAndSecondSmallest(digits);
		System.out.println("Smallest digit: " + smallest[0]);
		System.out.println("Second Smallest digit: " + smallest[1]);

		sc.close();
	}

}
