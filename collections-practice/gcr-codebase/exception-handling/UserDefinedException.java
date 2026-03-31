import java.util.Scanner;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class UserDefinedException {

	static void validateAge(int age) throws InvalidAgeException {
		if (age >= 18) {
			System.out.println("Access granted!");
		} else {
			throw new InvalidAgeException("Age must be 18 or above");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter the age: ");
			int age = sc.nextInt();
			validateAge(age);
		} catch (InvalidAgeException e) {
			System.out.println("Caught custom exception: " + e.getMessage());
		} finally {
			sc.close();
		}

	}
}
