package onlineExaminationSystem;

import java.util.*;

class Exam {
	private String examName;
	private List<Question> questions = new ArrayList<>();
	private long endTime;

	public Exam(String examName, int durationSeconds) {
		this.examName = examName;
		this.endTime = System.currentTimeMillis() + (durationSeconds * 1000);
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public int submitExam(List<String> answers) throws ExamTimeExpiredException {
		if (System.currentTimeMillis() > endTime) {
			throw new ExamTimeExpiredException("Exam Time Expired!");
		}

		int score = 0;
		for (int i = 0; i < questions.size(); i++) {
			score += questions.get(i).evaluateAnswer(answers.get(i));
		}
		return score;
	}

	public void showExam() {
		System.out.println("Exam: " + examName);
		for (Question q : questions) {
			System.out.println("- " + q.getQuestion());
		}
	}
}
