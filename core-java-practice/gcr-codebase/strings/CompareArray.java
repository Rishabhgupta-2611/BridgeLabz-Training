import java.util.*;

public class CompareArray {

	public static char[] getCharacters(String text) {
		char[] arr = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		return arr;
	}

	public static boolean compareArrays(char[] a, char[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		char[] manualArray = getCharacters(str);
		char[] builtInArray = str.toCharArray();

		System.out.println(compareArrays(manualArray, builtInArray));

		sc.close();
	}
}
