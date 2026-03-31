
import java.util.*;

public class MultiplesBelow100While {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		if (number <= 0 || number >= 100) {
			System.out.println("Enter a positive integer less than 100");
		} else {
			int i = 1;
			while (i < 100) {
				if (i % number == 0) {
					System.out.println(i);
				}
				i++;
			}
		}

		sc.close();
	}

}
