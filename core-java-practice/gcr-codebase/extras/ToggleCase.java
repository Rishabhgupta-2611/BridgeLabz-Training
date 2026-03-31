import java.util.Scanner;

public class ToggleCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String result = "";

		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z')
				result += (char) (ch + 32);
			else if (ch >= 'a' && ch <= 'z')
				result += (char) (ch - 32);
			else
				result += ch;
		}

		System.out.println("Modified String: " + result);
		sc.close();
	}
}
