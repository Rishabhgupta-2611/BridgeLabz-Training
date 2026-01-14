package onlineExaminationSystem;

class DescriptiveEvaluation implements EvaluationStrategy {

	@Override
	public int evaluate(String answer, String correctAnswer) {
		return answer.length() >= 5 ? 5 : 2; // simple logic
	}
}