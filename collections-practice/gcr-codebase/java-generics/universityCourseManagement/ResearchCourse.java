package universityCourseManagement;

class ResearchCourse extends CourseType {

	public ResearchCourse() {
		super("Research Work");
	}

	@Override
	public int getPassingMarks() {
		return 60;
	}
}
