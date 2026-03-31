import java.io.*;

public class UpdateEmployeeSalary {
	public static void main(String[] args) {

		String inputFile = "employees.csv";
		String outputFile = "updated_employees.csv";

		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
				FileWriter writer = new FileWriter(outputFile)) {

			writer.append(br.readLine()).append("\n");

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");
				String department = data[2];
				double salary = Double.parseDouble(data[3]);
				if (department.equalsIgnoreCase("IT")) {
					salary = salary + (salary * 0.10);
				}

				writer.append(data[0] + "," + data[1] + "," + department + "," + (int) salary + "\n");
			}

			System.out.println("Updated CSV file created successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
