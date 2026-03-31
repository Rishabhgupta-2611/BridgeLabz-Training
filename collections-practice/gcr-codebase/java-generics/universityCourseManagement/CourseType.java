package universityCourseManagement;

abstract class CourseType {
	private String evaluationMethod;

	public CourseType(String evaluationMethod) {
		this.evaluationMethod = evaluationMethod;
	}

	public String getEvaluationMethod() {
		return evaluationMethod;
	}

	public abstract int getPassingMarks();
}
