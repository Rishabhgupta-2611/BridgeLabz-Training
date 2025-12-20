import java.util.*;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		int[] table = new int[10];

		for (int i = 1; i <= 10; i++) {
			table[i - 1] = number * i;
		}

		for (int j = 1; j <= 10; j++) {
			System.out.println(number + " * " + j + " = " + table[j - 1]);
		}

		sc.close();
	}

}
