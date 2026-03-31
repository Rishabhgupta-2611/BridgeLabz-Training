import java.util.*;

public class UniqueCharacterFrequency {

	static char[] uniqueCharacters(String text) {

		char[] temp = new char[text.length()];
		int index = 0;

		for (int i = 0; i < text.length(); i++) {
			boolean found = false;

			for (int j = 0; j < i; j++) {
				if (text.charAt(i) == text.charAt(j)) {
					found = true;
					break;
				}
			}
			if (!found) {
				temp[index++] = text.charAt(i);
			}
		}

		char[] unique = new char[index];
		for (int i = 0; i < index; i++) {
			unique[i] = temp[i];
		}
		return unique;
	}

	static String[][] frequencyUsingUnique(String text) {

		int[] freq = new int[256];

		for (int i = 0; i < text.length(); i++) {
			freq[text.charAt(i)]++;
		}

		char[] uniqueChars = uniqueCharacters(text);
		String[][] result = new String[uniqueChars.length][2];

		for (int i = 0; i < uniqueChars.length; i++) {
			result[i][0] = String.valueOf(uniqueChars[i]);
			result[i][1] = String.valueOf(freq[uniqueChars[i]]);
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		String[][] result = frequencyUsingUnique(text);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
		sc.close();
	}
}
