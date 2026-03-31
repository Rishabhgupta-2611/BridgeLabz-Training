import java.util.*;

public class NumberFormat {
	
	public static void generateException(String text) {
		int num = Integer.parseInt(text);
		System.out.println(num);
	}
	
	public static void handleException(String text) {
		try {
			int num = Integer.parseInt(text);
			System.out.println(num);
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException Handled");
		}
		catch (RuntimeException e) {
			System.out.println("RuntimeException Handled");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String text = input.next();
		handleException(text);
		
		input.close();
	}

}
