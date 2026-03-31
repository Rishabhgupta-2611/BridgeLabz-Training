public class ParagraphAnalyzer {

	public static void analyzeParagraph(String paragraph, String oldWord, String newWord) {
		if (paragraph == null || paragraph.trim().isEmpty()) {
			System.out.println("The paragraph is empty or contains only spaces.");
			return;
		}
		paragraph = paragraph.trim();
		String[] words = paragraph.split("\\s+");
		int wordCount = words.length;
		String longestWord = words[0];
		for (String word : words) {
			if (word.length() > longestWord.length()) {
				longestWord = word;
			}
		}

		String replacedParagraph = paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);

		System.out.println("Word Count: " + wordCount);
		System.out.println("Longest Word: " + longestWord);
		System.out.println("Updated Paragraph:");
		System.out.println(replacedParagraph);
	}

	public static void main(String[] args) {

		String paragraph = "Java is a powerful programming language. Java is widely used.";
		analyzeParagraph(paragraph, "java", "Python");
	}
}
