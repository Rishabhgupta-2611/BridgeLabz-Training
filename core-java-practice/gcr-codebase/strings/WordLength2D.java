
import java.util.*;

public class WordLength2D {

	// finding length without using length()
	static int findLength(String s) {
		int i = 0;
		try {
			while (true) {
				s.charAt(i);
				i++;
			}
		} catch (Exception e) {
			// stops here
		}
		return i;
	}

	// split words without split()
	static String[] splitWords(String text) {
		int len = findLength(text);

		// count words
		int wordCount = 1;
		for (int i = 0; i < len; i++) {
			if (text.charAt(i) == ' ')
				wordCount++;
		}

		String[] words = new String[wordCount];
		int index = 0;
		int start = 0;

		// extract words till space
		for (int i = 0; i < len; i++) {
			if (text.charAt(i) == ' ') {
				String word = "";
				for (int j = start; j < i; j++) {
					word += text.charAt(j);
				}
				words[index++] = word;
				start = i + 1;
			}
		}

		// last word (after final space)
		String lastWord = "";
		for (int j = start; j < len; j++) {
			lastWord += text.charAt(j);
		}
		words[index] = lastWord;

		return words;
	}

	// create 2D array [word][length]
	static String[][] create2D(String[] words) {
		String[][] arr = new String[words.length][2];

		for (int i = 0; i < words.length; i++) {
			arr[i][0] = words[i];
			arr[i][1] = String.valueOf(findLength(words[i]));
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter text: ");
		String text = sc.nextLine();

		String[] words = splitWords(text);
		String[][] data = create2D(words);

		System.out.println("\nWord\tLength");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i][0] + "\t" + Integer.parseInt(data[i][1]));
		}
		sc.close();
	}
}
