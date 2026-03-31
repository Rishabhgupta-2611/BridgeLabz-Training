package universityCourseManagement;

import java.util.List;

class CourseUtil {

	public static void displayCourses(List<? extends CourseType> courseTypes) {

		for (CourseType type : courseTypes) {
			System.out.println(type.getEvaluationMethod() + " | Passing Marks: " + type.getPassingMarks());
		}
	}
}
