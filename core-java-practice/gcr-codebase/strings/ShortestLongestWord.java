import java.util.*;

public class ShortestLongestWord {

	// method to find length without using length()
	static int findLength(String s) {
		int count = 0;
		try {
			while (true) {
				s.charAt(count);
				count++;
			}
		} catch (Exception e) {
			// stops when index goes out of range
		}
		return count;
	}

	// method to split text into words using charAt()
	static String[] splitWords(String text) {

		int len = findLength(text);
		int wordCount = 1;

		// count number of words
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
					word = word + text.charAt(j);
				}
				words[index++] = word;
				start = i + 1;
			}
		}

		// handle last word
		String lastWord = "";
		for (int j = start; j < len; j++) {
			lastWord = lastWord + text.charAt(j);
		}
		words[index] = lastWord;

		return words;
	}

	// create 2D array of word and its length
	static String[][] createWordLengthArray(String[] words) {

		String[][] data = new String[words.length][2];

		for (int i = 0; i < words.length; i++) {
			data[i][0] = words[i];
			data[i][1] = String.valueOf(findLength(words[i]));
		}

		return data;
	}

	// find shortest and longest word index
	static int[] findShortestLongest(String[][] data) {

		int minLen = Integer.parseInt(data[0][1]);
		int maxLen = minLen;

		int minIndex = 0;
		int maxIndex = 0;

		for (int i = 1; i < data.length; i++) {
			int len = Integer.parseInt(data[i][1]);

			if (len < minLen) {
				minLen = len;
				minIndex = i;
			}

			if (len > maxLen) {
				maxLen = len;
				maxIndex = i;
			}
		}

		return new int[] { minIndex, maxIndex };
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter text: ");
		String text = sc.nextLine();

		String[] words = splitWords(text);
		String[][] wordLengthData = createWordLengthArray(words);
		int[] result = findShortestLongest(wordLengthData);

		System.out.println("\nWord\tLength");
		for (int i = 0; i < wordLengthData.length; i++) {
			System.out.println(wordLengthData[i][0] + "\t" + Integer.parseInt(wordLengthData[i][1]));
		}

		System.out.println("\nShortest Word: " + wordLengthData[result[0]][0]);

		System.out.println("Longest Word: " + wordLengthData[result[1]][0]);

		sc.close();
	}
}
