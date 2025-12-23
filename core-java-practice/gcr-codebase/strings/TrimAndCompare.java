import java.util.*;

class TrimUsingCharAt {

	// method to find start and end index after trimming spaces
	static int[] findTrimIndexes(String text) {
		int start = 0;
		int end = text.length() - 1;

		// loop to skip leading spaces
		while (start <= end && text.charAt(start) == ' ') {
			start++;
		}

		// loop to skip trailing spaces
		while (end >= start && text.charAt(end) == ' ') {
			end--;
		}

		// returning start and end index
		return new int[] { start, end };
	}

	// method to create substring using charAt()
	static String createSubstring(String text, int start, int end) {
		String result = "";

		for (int i = start; i <= end; i++) {
			result = result + text.charAt(i);
		}

		return result;
	}

	// method to compare two strings using charAt()
	static boolean compareStrings(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string with spaces: ");
		String text = sc.nextLine();

		// custom trimming using charAt()
		int[] indexes = findTrimIndexes(text);
		String customTrim = createSubstring(text, indexes[0], indexes[1]);

		// built-in trim
		String builtInTrim = text.trim();

		// compare both strings
		boolean result = compareStrings(customTrim, builtInTrim);

		// display output
		System.out.println("\nTrimmed using charAt(): '" + customTrim + "'");
		System.out.println("Trimmed using trim():   '" + builtInTrim + "'");
		System.out.println("Both strings are same?  " + result);

		sc.close();
	}
}
