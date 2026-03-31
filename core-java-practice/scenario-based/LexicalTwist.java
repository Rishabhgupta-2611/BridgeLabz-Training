import java.util.*;

public class LexicalTwist {

	static boolean isVovel(char ch) {
		return "aeiouAEIOU".indexOf(ch) != -1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the first word: ");
		String word1 = input.nextLine();

		System.out.println("Enter the second word: ");
		String word2 = input.nextLine();

		input.close();
		// Validation
		if (word1.contains(" ")) {
			System.out.println(word1 + " is an invalid word");
			return;
		}

		if (word2.contains(" ")) {
			System.out.println(word1 + " is an invalid word");
			return;
		}

		// Reverse the word
		String rev = "";
		for (int i = word1.length() - 1; i >= 0; i--) {
			rev += word1.charAt(i);
		}

		// if the second word is a reversed version of the first word

		if (rev.equalsIgnoreCase(word2)) {
			String result = "";
			for (int i = 0; i < rev.length(); i++) {
				char ch = Character.toLowerCase(rev.charAt(i));
				if (isVovel(ch)) {
					result += '@';
				} else {
					result += ch;
				}
			}
			System.out.println(result);
		}

		// if the second word is not reversed version of the first word
		else {
			String combined = (word1 + word2).toUpperCase();
			int vovels = 0;
			int consonants = 0;

			for (int i = 0; i < combined.length(); i++) {
				char ch = combined.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					if (isVovel(ch)) {
						vovels++;
					} else {
						consonants++;
					}
				}
			}
			if (vovels == consonants) {
				System.out.println("Vowels and consonants are equal");
			} else if (vovels > consonants) {
				String printed = "";
				for (int i = 0; i < combined.length() && printed.length() < 2; i++) {
					char ch = combined.charAt(i);
					if (isVovel(ch) && printed.indexOf(ch) == -1) {
						printed += ch;
					}
				}
				System.out.println(printed);
			} else {
				String printed = "";
				for (int i = 0; i < combined.length() && printed.length() < 2; i++) {
					char ch = combined.charAt(i);
					if (!isVovel(ch) && ch >= 'A' && ch <= 'Z' && printed.indexOf(ch) == -1) {
						printed += ch;
					}
				}

				System.out.println(printed);
			}
		}
	}
}
