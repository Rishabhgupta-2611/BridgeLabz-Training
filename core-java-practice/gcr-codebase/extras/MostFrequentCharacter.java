import java.util.Scanner;

public class MostFrequentCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int[] freq = new int[256];
		for (char ch : str.toCharArray())
			freq[ch]++;

		char result = str.charAt(0);
		int max = freq[result];

		for (char ch : str.toCharArray()) {
			if (freq[ch] > max) {
				max = freq[ch];
				result = ch;
			}
		}

		System.out.println("Most Frequent Character: " + result);
		sc.close();
	}
}
