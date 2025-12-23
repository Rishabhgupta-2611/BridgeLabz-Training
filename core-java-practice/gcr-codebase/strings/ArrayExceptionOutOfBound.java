import java.util.*;

public class ArrayExceptionOutOfBound {

	public static void generateException(String[] names) {
		System.out.println(names[names.length]);
	}

	public static void handleException(String[] names) {
		try {
			System.out.println(names[names.length]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException Handled");
		} catch (RuntimeException e) {
			System.out.println("RuntimeException Handled");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] names = new String[n];

		for (int i = 0; i < n; i++) {
			names[i] = sc.next();
		}
		handleException(names);

		sc.close();
	}
}
