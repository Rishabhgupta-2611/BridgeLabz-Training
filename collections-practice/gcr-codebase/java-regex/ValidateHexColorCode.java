import java.util.*;

public class ValidateHexColorCode {

	public static boolean isValidHexColor(String hexColor) {
		return hexColor.matches("^#[a-fA-F0-9]{6}$");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hexColor = sc.nextLine();
		if (isValidHexColor(hexColor)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
		sc.close();
	}
}
