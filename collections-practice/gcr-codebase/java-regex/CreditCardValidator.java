import java.util.Scanner;

public class CreditCardValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String card = sc.nextLine();
		System.out.println(card.matches("^(4\\d{15}|5\\d{15})$"));
		sc.close();
	}
}
