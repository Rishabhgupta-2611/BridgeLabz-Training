import java.time.LocalDate;
import java.util.*;

public class DateArithmetic {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter date (yyyy-mm-dd): ");
		String inputDate = input.nextLine();

		LocalDate date = LocalDate.parse(inputDate);

		LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);

		System.out.println("Final Date after operations: " + result);
		input.close();
	}
}
