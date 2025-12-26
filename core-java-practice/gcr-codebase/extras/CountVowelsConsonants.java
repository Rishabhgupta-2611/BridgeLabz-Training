import java.util.Scanner;

public class CountVowelsConsonants {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int vowels = 0, consonants = 0;
		str = str.toLowerCase();

		for (char ch : str.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					vowels++;
				else
					consonants++;
			}
		}

		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + consonants);
		sc.close();
	}
}
