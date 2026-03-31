
import java.util.*;

public class MultiplesBelow100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		if (number <= 0 || number >= 100) {
			System.out.println("Enter a positive number less than 100!");
		} else {
			for (int i = 1; i < 100; i++) {
				if (i % number == 0) {
					System.out.println(i);
				}
			}
		}

		sc.close();
	}

}
