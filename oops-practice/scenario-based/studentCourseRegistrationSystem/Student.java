package studentCourseRegistrationSystem;

import java.util.*;

class Student extends Person implements RegistrationService {

	// Encapsulated data
	private String studentId;
	private List<String> courses = new ArrayList<>();
	private Map<String, String> grades = new HashMap<>();

	private static final int MAX_COURSES = 3;

	public Student(String studentId, String name, int age) {
		super(name, age);
		this.studentId = studentId;
	}

	public void enrollCourse(String course) throws CourseLimitExceededException {
		if (courses.size() >= MAX_COURSES) {
			throw new CourseLimitExceededException("Course limit exceeded (Max 3)");
		}
		courses.add(course);
		grades.put(course, "Not Graded");
		System.out.println(name + " enrolled in " + course);
	}

	public void dropCourse(String course) {
		if (courses.remove(course)) {
			grades.remove(course);
			System.out.println(name + " dropped " + course);
		} else {
			System.out.println("Course not found");
		}
	}

	public void assignGrade(String course, String grade) {
		if (grades.containsKey(course)) {
			grades.put(course, grade);
		}
	}

	public void viewGrades() {
		System.out.println("\nGrades of " + name);
		for (String course : grades.keySet()) {
			System.out.println(course + " : " + grades.get(course));
		}
	}
}
