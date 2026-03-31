public class EduQuiz {

	public static int calculateScore(String[] correct, String[] student) {
		int score = 0;

		for (int i = 0; i < correct.length; i++) {
			if (student[i].equalsIgnoreCase(correct[i])) {
				score++;
			}
		}
		return score;
	}

	public static void main(String[] args) {

		String[] correctAnswers = { "A", "B", "C", "D", "A", "C", "B", "D", "A", "C" };

		String[] studentAnswers = { "a", "b", "C", "d", "B", "c", "b", "A", "a", "c" };

		System.out.println("Quiz Feedback:");
		for (int i = 0; i < correctAnswers.length; i++) {
			if (studentAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
				System.out.println("Question " + (i + 1) + ": Correct");
			} else {
				System.out.println("Question " + (i + 1) + ": Incorrect");
			}
		}

		int score = calculateScore(correctAnswers, studentAnswers);
		double percentage = (score / 10.0) * 100;

		System.out.println("Total Score: " + score + "/10");
		System.out.println("Percentage: " + percentage + "%");

		if (percentage >= 50) {
			System.out.println("Result: PASS");
		} else {
			System.out.println("Result: FAIL");
		}
	}
}
