import java.util.Scanner;

public class ReplaceWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String oldWord = sc.next();
		String newWord = sc.next();

		String result = sentence.replace(oldWord, newWord);
		System.out.println("Modified Sentence: " + result);
		sc.close();
	}
}
