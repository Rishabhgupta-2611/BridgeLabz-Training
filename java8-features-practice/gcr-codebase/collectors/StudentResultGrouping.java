import java.util.*;
import java.util.stream.Collectors;

class Student {
	String name;
	String grade;

	Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
}

public class StudentResultGrouping {
	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("Rishabh", "A"), new Student("Sarthak", "B"),
				new Student("Aman", "A"), new Student("Pankaj", "C"), new Student("Yuvan", "B"));

		Map<String, List<String>> result = students.stream()
				.collect(Collectors.groupingBy(s -> s.grade, Collectors.mapping(s -> s.name, Collectors.toList())));

		System.out.println(result);
	}
}