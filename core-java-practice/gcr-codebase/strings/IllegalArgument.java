import java.util.*;

public class IllegalArgument {

	public static void generateException(String text) {
		System.out.println(text.substring(2, 5));
	}

	public static void handleException(String text) {
		try {
			System.out.println(text.substring(5, 2));
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal Argument Exception Handled");
		} catch (RuntimeException e) {
			System.out.println("Run Time Exception Handled");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();

		handleException(text);

		sc.close();
	}
}
