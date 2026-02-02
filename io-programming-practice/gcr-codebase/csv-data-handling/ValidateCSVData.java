import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSVData {

	public static void main(String[] args) {

		String filePath = "users.csv";

		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern emailPattern = Pattern.compile(emailRegex);

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;

			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String email = data[2];
				String phone = data[3];

				if (!emailPattern.matcher(email).matches()) {
					System.out.println("Invalid Email: " + email);
				}

				if (!phone.matches("\\d{10}")) {
					System.out.println("Invalid Phone: " + phone);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
