import java.util.regex.*;

public class ExtractLinks {
	public static void main(String[] args) {
		String text = "Visit https://www.google.com and http://example.org for more info.";

		Pattern p = Pattern.compile("https?://\\S+");
		Matcher m = p.matcher(text);

		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
