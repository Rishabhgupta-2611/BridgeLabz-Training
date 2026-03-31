import java.util.*;

public class TableSixToNine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		int[] multiplicationResult = new int[4];

		int idx = 0;
		for (int j = 6; j <= 9; j++) {
			multiplicationResult[idx] = number * j;
			idx++;
		}

		idx = 0;
		for (int j = 6; j <= 9; j++) {
			System.out.println(number + " * " + j + " = " + multiplicationResult[idx]);
			idx++;
		}

		sc.close();
	}

}
