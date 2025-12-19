import java.util.*;

public class SmallestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Three Numbers: ");
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();

		boolean isFirstSmallest = number1 < number2 && number1 < number3;
		boolean isSecondSmallest = number2 < number1 && number2 < number3;
		boolean isThirdSmallest = number3 < number1 && number3 < number2;

		System.out.println("Is the first number the smallest? " + isFirstSmallest);
		System.out.println("Is the second number the smallest? " + isSecondSmallest);
		System.out.println("Is the third number the smallest? " + isThirdSmallest);

		sc.close();
	}
}
