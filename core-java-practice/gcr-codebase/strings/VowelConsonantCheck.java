import java.util.Scanner;

public class VowelConsonantCheck {

	static String checkCharType(char ch) {
		// convert uppercase to lowercase using ASCII
		if (ch >= 'A' && ch <= 'Z') {
			ch = (char) (ch + 32);
		}

		// check if alphabet
		if (ch >= 'a' && ch <= 'z') {

			// check vowel
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				return "Vowel";
			} else {
				return "Consonant";
			}
		}

		// if not an alphabet
		return "Not a Letter";
	}

	// method to analyze string and store result in 2D array
	static String[][] analyzeString(String text) {

		int len = text.length();
		String[][] result = new String[len][2];

		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);

			result[i][0] = String.valueOf(ch);
			result[i][1] = checkCharType(ch);
		}

		return result;
	}

	// method to display 2D array in tabular format
	static void displayResult(String[][] data) {

		System.out.println("\nCharacter\tType");
		System.out.println("----------------------");

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i][0] + "\t\t" + data[i][1]);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String text = sc.nextLine();

		String[][] output = analyzeString(text);
		displayResult(output);

		sc.close();
	}
}
