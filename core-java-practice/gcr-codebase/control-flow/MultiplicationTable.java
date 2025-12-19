import java.util.*;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();

		for (int i = 6; i <= 9; i++) { // Print multiplication table from 6 to 9
			System.out.println(number + " * " + i + " = " + (number * i));
		}

		sc.close();
	}
}
