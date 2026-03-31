package studentCourseRegistrationSystem;

public class Main {
	public static void main(String[] args) {
		Student s = new Student("A100", "Aryan", 35);

		try {
			s.enrollCourse("Java");
			s.enrollCourse("DBMS");
			s.enrollCourse("Spring boot");
			s.enrollCourse("OS");
		} catch (CourseLimitExceededException e) {
			System.out.println(e.getMessage());
		}

		s.assignGrade("Java", "A");
		s.assignGrade("DBMS", "A+");
		s.assignGrade("Spring boot", "A");
		s.assignGrade("OS", "B+");

		s.viewGrades();

		System.out.println("\nDropping Courses");
		s.dropCourse("Java");

		s.viewGrades();

	}
}
