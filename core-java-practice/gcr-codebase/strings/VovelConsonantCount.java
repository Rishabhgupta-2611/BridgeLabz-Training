import java.util.*;

public class VovelConsonantCount {

	static String checkCharType(char ch) {

		if (ch >= 'A' && ch <= 'Z') {
			ch = (char) (ch + 32);
		}

		if (ch >= 'a' && ch <= 'z') {

			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				return "Vowel";
			} else {
				return "Consonant";
			}
		}

		return "Not a Letter";
	}

	static int[] countVowelsAndConsonants(String text) {

		int vowelCount = 0;
		int consonantCount = 0;

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			String type = checkCharType(ch);

			if (type.equals("Vowel")) {
				vowelCount++;
			} else if (type.equals("Consonant")) {
				consonantCount++;
			}
		}

		return new int[] { vowelCount, consonantCount };
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String text = sc.nextLine();

		int[] result = countVowelsAndConsonants(text);

		System.out.println("\nVowels Count      : " + result[0]);
		System.out.println("Consonants Count : " + result[1]);

		sc.close();
	}
}
