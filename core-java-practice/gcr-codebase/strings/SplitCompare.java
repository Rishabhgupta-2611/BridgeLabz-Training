import java.util.*;

public class SplitCompare {

	static int findLength(String str) {
		int i = 0;
		try {
			while (true) {
				str.charAt(i);
				i++;
			}
		} catch (Exception e) {
		}
		return i;
	}

	static String[] customSplit(String text) {
		int len = findLength(text);
		int spaces = 0;

		// count words
		for (int i = 0; i < len; i++) {
			if (text.charAt(i) == ' ')
				spaces++;
		}

		String[] words = new String[spaces + 1];
		int index = 0, start = 0;

		for (int i = 0; i <= len; i++) {
			if (i == len || text.charAt(i) == ' ') {
				String word = "";
				for (int j = start; j < i; j++) {
					word += text.charAt(j);
				}
				words[index++] = word;
				start = i + 1;
			}
		}
		return words;
	}

	static boolean compareArrays(String[] a, String[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(b[i]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter text: ");
		String text = sc.nextLine();

		String[] mySplit = customSplit(text);
		String[] builtSplit = text.split(" ");

		boolean result = compareArrays(mySplit, builtSplit);
		System.out.println("Both splits same? " + result);

		sc.close();
	}
}
