import java.util.*;

public class StringLengthCheck {

	// method to find length without using length()
	static int findLength(String str) {
		int count = 0;

		// infinite loop idea
		try {
			while (true) {
				str.charAt(count);
				count++; // keep increasing
			}
		} catch (Exception e) {
			// exception comes when index goes out of range
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string: ");
		String text = sc.next();

		int myLen = findLength(text);
		int builtLen = text.length();

		System.out.println("Length without length(): " + myLen);
		System.out.println("Length using length(): " + builtLen);

		sc.close();
	}
}
