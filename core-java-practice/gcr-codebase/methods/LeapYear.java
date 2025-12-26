import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();

		if (year < 1582) {
			System.out.println("Invalid Year");
			return;
		}

		if (isLeapYear(year)) {
			System.out.println("Year is a Leap Year");
		} else {
			System.out.println("Year is not a Leap Year");
		}
	}

	static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
