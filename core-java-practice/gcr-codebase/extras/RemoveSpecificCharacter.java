import java.util.Scanner;

public class RemoveSpecificCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char remove = sc.next().charAt(0);

		String result = "";
		for (char ch : str.toCharArray()) {
			if (ch != remove)
				result += ch;
		}

		System.out.println("Modified String: " + result);
		sc.close();
	}
}
