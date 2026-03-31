import java.util.*;

public class NumberCheck {

	public static int checkNumber(int num) {
		if (num > 0) {
			return 1;
		} else if (num < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		int result = checkNumber(num);

		if (result == 1) {
			System.out.println("Number is positive");
		} else if (result == -1) {
			System.out.println("Number is negative");
		} else {
			System.out.println("Number is zero");
		}

		sc.close();
	}
}
