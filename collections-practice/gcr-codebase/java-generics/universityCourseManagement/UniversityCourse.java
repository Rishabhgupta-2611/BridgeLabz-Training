package universityCourseManagement;

import java.util.ArrayList;
import java.util.List;

public class UniversityCourse {

	public static void main(String[] args) {

		Course<ExamCourse> examCourse = new Course<>("Data Structures", new ExamCourse());

		Course<AssignmentCourse> assignmentCourse = new Course<>("Web Development", new AssignmentCourse());

		Course<ResearchCourse> researchCourse = new Course<>("AI Research", new ResearchCourse());

		List<CourseType> courseTypes = new ArrayList<>();
		courseTypes.add(examCourse.getCourseType());
		courseTypes.add(assignmentCourse.getCourseType());
		courseTypes.add(researchCourse.getCourseType());

		CourseUtil.displayCourses(courseTypes);
	}
}
