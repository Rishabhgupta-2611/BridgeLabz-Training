import java.util.*;

public class CharacterFrequency {

	static String[][] findFrequency(String text) {

		int[] freq = new int[256];

		for (int i = 0; i < text.length(); i++) {
			freq[text.charAt(i)]++;
		}

		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (freq[text.charAt(i)] > 0)
				count++;
		}

		String[][] result = new String[count][2];
		int index = 0;

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (freq[ch] > 0) {
				result[index][0] = String.valueOf(ch);
				result[index][1] = String.valueOf(freq[ch]);
				index++;
				freq[ch] = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		String[][] result = findFrequency(text);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}

		sc.close();
	}
}
