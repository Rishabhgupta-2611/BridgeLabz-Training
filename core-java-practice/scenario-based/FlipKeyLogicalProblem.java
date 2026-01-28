import java.util.*;

public class FlipKeyLogicalProblem {

	public static String CleanseAndInvert(String input) {
		if (input == null || input.length() < 6)
			return "";

		else if (input.contains(" ") || input.matches(".*\\d.*"))
			return "";

		input = input.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) % 2 != 0)
				result.append(input.charAt(i));
		}
		result.reverse();
		char[] ch = result.toString().toCharArray();
		for (int i = 0; i < ch.length; i += 2) {
			ch[i] = Character.toUpperCase(ch[i]);
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String output = CleanseAndInvert(input);
		if (output.isEmpty()) {
			System.out.println("Invalid input");
		} else {
			System.out.println("The generated key is - " + output);
		}
		sc.close();
	}

}
