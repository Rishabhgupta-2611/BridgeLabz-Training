import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVToStudent {

	static class Student {
		private final int id;
		private final String name;
		private final int age;
		private final int marks;

		public Student(int id, String name, int age, int marks) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.marks = marks;
		}

		@Override
		public String toString() {
			return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
		}
	}

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		String filePath = "students.csv";

		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

			br.readLine();
			String line;

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				if (data.length != 4)
					continue;

				Student student = new Student(Integer.parseInt(data[0].trim()), data[1].trim(),
						Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim()));

				students.add(student);
			}

		} catch (IOException e) {
			System.err.println("Error reading CSV file: " + e.getMessage());
		}

		// Print students using Java 8 Stream
		students.forEach(System.out::println);
	}
}
