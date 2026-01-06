public class SentenceFormatter {

	public static String formatParagraph(String paragraph) {
		paragraph = paragraph.trim();
		paragraph = paragraph.replaceAll("\\s+", " ");
		paragraph = paragraph.replaceAll("\\s*([.!?])\\s*", "$1 ");

		char[] chars = paragraph.toCharArray();
		boolean capitalizeNext = true;

		for (int i = 0; i < chars.length; i++) {
			if (capitalizeNext && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				capitalizeNext = false;
			}
			if (chars[i] == '.' || chars[i] == '?' || chars[i] == '!') {
				capitalizeNext = true;
			}
		}

		return new String(chars).trim();
	}

	public static void main(String[] args) {
		String input = "   hello world.this   is a test!how are you?  i am fine. ";
		System.out.println(formatParagraph(input));
	}
}
