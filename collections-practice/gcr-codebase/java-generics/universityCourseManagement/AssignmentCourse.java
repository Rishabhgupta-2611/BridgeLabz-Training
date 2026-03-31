package universityCourseManagement;

class AssignmentCourse extends CourseType {

	public AssignmentCourse() {
		super("Assignments");
	}

	@Override
	public int getPassingMarks() {
		return 50;
	}
}
