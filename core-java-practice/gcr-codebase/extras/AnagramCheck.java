import java.util.Scanner;

public class AnagramCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();

		if (s1.length() != s2.length()) {
			System.out.println("Not Anagrams");
			return;
		}

		int[] freq = new int[256];
		for (char ch : s1.toCharArray())
			freq[ch]++;
		for (char ch : s2.toCharArray())
			freq[ch]--;

		for (int i : freq) {
			if (i != 0) {
				System.out.println("Not Anagrams");
				return;
			}
		}

		System.out.println("Anagrams");
	}
}
