package studentCourseRegistrationSystem;

public interface RegistrationService {
	void enrollCourse(String course) throws CourseLimitExceededException;

	void dropCourse(String course);

	void viewGrades();

}
