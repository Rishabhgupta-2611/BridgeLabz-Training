import java.util.regex.*;

public class ExtractCurrency {
	public static void main(String[] args) {
		String text = "The price is $45.99, and the discount is 10.50.";
		Pattern p = Pattern.compile("\\$*\\d+(\\.\\d+)*");
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
	}
}
