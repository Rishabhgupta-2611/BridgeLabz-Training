
public class PalindromeChecker {

	String text;

	PalindromeChecker(String text) {
		this.text = text;
	}

	void checkPalindrome() {
		String cleaned = text.replaceAll("\\s+", "").toLowerCase();
		String reversed = "";

		for (int i = cleaned.length() - 1; i >= 0; i--) {
			reversed += cleaned.charAt(i);
		}

		if (cleaned.equals(reversed))
			System.out.println(text + " is palindrome");
		else
			System.out.println(text + " is not Palindrome");
	}

	public static void main(String[] args) {
		PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
		PalindromeChecker p2 = new PalindromeChecker("Hello");

		p1.checkPalindrome();
		p2.checkPalindrome();
	}
}
