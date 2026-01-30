import java.util.Scanner;

public class ValidateIPAddress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		System.out.println(
				ip.matches("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$"));
		sc.close();

	}
}
