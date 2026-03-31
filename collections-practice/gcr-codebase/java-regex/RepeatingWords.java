import java.util.regex.*;

public class RepeatingWords {
	public static void main(String[] args) {
		String text = "This is is a repeated repeated word test.";
		Pattern p = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.print(m.group(1) + " ");
		}
	}
}
