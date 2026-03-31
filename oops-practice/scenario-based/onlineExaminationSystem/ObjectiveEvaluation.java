package onlineExaminationSystem;

class ObjectiveEvaluation implements EvaluationStrategy {

	@Override
	public int evaluate(String answer, String correctAnswer) {
		return answer.equalsIgnoreCase(correctAnswer) ? 1 : 0;
	}
}