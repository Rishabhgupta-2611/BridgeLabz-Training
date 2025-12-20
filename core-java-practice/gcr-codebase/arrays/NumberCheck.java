import java.util.*;

public class NumberCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int user[] = new int[5];

		for (int i = 0; i < 5; i++) {
			user[i] = sc.nextInt();
		}

		for (int i = 0; i < user.length; i++) {
			if (user[i] > 0) {
				if (user[i] % 2 == 0) {
					System.out.println(user[i] + " is Positive and Even");
				} else {
					System.out.println(user[i] + " is Positive and Odd");
				}
			} else if (user[i] < 0) {
				System.out.println(user[i] + " is Negative");
			} else {
				System.out.println(user[i] + " is Zero");
			}
		}

		if (user[0] == user[4]) {
			System.out.println("First and Last elements are Equal");
		} else if (user[0] > user[4]) {
			System.out.println("First element is Greater than Last");
		} else {
			System.out.println("First element is Less than Last");
		}

		sc.close();
	}

}
