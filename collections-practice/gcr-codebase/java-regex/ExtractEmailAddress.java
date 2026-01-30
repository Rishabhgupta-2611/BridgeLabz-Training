import java.util.regex.*;

public class ExtractEmailAddress {
	public static void main(String[] args) {
		String text = "Contact us at support@example.com and info@company.org";
		
		Pattern p = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z]+[.][a-z]+");
		Matcher m = p.matcher(text);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}
