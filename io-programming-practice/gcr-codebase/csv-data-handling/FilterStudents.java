import java.io.*;

public class FilterStudents {
	public static void main(String[] args) {
		String filePath = "students.csv";
		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			br.readLine();

			System.out.println("Students scoring more than 80: ");
			System.out.println(" ");

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");
				int marks = Integer.parseInt(data[3]);

				if (marks > 80) {

					System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Marks: " + marks);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
