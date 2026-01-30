
public class CensorBadWords {
	public static void main(String[] args) {
		String text = "This is a damn bad example with some stupid words.";
		String badWordsRegex = "\\b(damn|stupid)\\b";
		text = text.replaceAll(badWordsRegex, "****");
		System.out.println(text);
	}
}
