package universityCourseManagement;

class ExamCourse extends CourseType {

	public ExamCourse() {
		super("Written Exam");
	}

	@Override
	public int getPassingMarks() {
		return 40;
	}
}
