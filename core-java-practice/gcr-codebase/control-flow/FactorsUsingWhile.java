
import java.util.*;

public class FactorsUsingWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		if (number <= 0) {
			System.out.println("Enter a positive number only!");
		} else {
			int i = 1;
			while (i < number) {
				if (number % i == 0) {
					System.out.println(i);
				}
				i++;
			}
		}

		sc.close();
	}

}
