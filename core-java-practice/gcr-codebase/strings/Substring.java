import java.util.Scanner;

public class Substring {

	static String manualSubstring(String s1, int start, int end) {
		String result = "";
		for (int i = start; i < end; i++) {
			result += s1.charAt(i);
		}
		return result;
	}

	static boolean manualCompare(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) { // Compare each character
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int start = sc.nextInt();
		int end = sc.nextInt();

		String manual = str.substring(start, end);
		String builtIn = manualSubstring(str, start, end);
		boolean areEqual = manualCompare(manual, builtIn);
		System.out.println(areEqual);
		sc.close();

	}

}
