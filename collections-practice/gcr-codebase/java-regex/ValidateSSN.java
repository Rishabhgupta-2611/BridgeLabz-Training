
public class ValidateSSN {
	public static void main(String[] args) {
		String ssn = "123-45-6789";
		System.out.println(ssn.matches("\\b\\d{3}-\\d{2}-\\d{4}\\b"));
	}
}
