import java.io.*;
import java.util.*;

public class SearchEmployee {

	public static void main(String[] args) {

		String filePath = "employees.csv";
		String line;
		boolean found = false;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter employee name: ");
		String searchName = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");
				if (data[1].equalsIgnoreCase(searchName)) {

					System.out.println("Employee Found");
					System.out.println("Department: " + data[2]);
					System.out.println("Salary: " + data[3]);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Employee not found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}