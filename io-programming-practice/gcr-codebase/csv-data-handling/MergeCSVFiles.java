import java.io.*;
import java.util.*;

public class MergeCSVFiles {

	public static void main(String[] args) {

		String file1 = "students1.csv";
		String file2 = "students2.csv";
		String outputFile = "merged_students.csv";

		Map<String, String[]> studentMap = new HashMap<>();

		try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				FileWriter writer = new FileWriter(outputFile)) {

			String line;

			br1.readLine(); // skip header
			while ((line = br1.readLine()) != null) {
				String[] data = line.split(",");
				studentMap.put(data[0], new String[] { data[1], data[2] });
			}

			writer.write("ID,Name,Age,Marks,Grade\n");

			br2.readLine();
			while ((line = br2.readLine()) != null) {

				String[] data = line.split(",");
				String id = data[0];

				if (studentMap.containsKey(id)) {
					String[] s = studentMap.get(id);

					writer.write(id + "," + s[0] + "," + s[1] + "," + data[1] + "," + data[2] + "\n");
				}
			}

			System.out.println("CSV files merged successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
