package onlineExaminationSystem;

class Question {
	private String question;
	private String correctAnswer;
	private EvaluationStrategy strategy;

	public Question(String question, String correctAnswer, EvaluationStrategy strategy) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.strategy = strategy;
	}

	public int evaluateAnswer(String answer) {
		return strategy.evaluate(answer, correctAnswer);
	}

	public String getQuestion() {
		return question;
	}
}
