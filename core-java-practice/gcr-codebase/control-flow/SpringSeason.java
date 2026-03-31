import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Day: ");
		int day = sc.nextInt();
		System.out.print("Enter The Month: ");
		int month = sc.nextInt();

		boolean isSpring = (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
		if (isSpring) {
			System.out.println("Its a Spring Season");
		} else {
			System.out.println("Not a Spring Season");
		}
		sc.close();

	}

}
