package onlineExaminationSystem;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		Student student = new Student("S101", "Aryan");

		Exam exam = new Exam("Java Test", 60);

		exam.addQuestion(new Question("Java is OOP language? (Yes/No)", "Yes", new ObjectiveEvaluation()));

		exam.addQuestion(new Question("Explain OOP concepts", "OOP", new DescriptiveEvaluation()));

		exam.showExam();

		List<String> answers = new ArrayList<>();
		answers.add("Yes");
		answers.add("OOP has classes and objects");

		try {
			int score = exam.submitExam(answers);
			System.out.println("\nStudent: " + student.getName());
			System.out.println("Maximum marks: 6");
			System.out.println("Final Score: " + score);
		} catch (ExamTimeExpiredException e) {
			System.out.println(e.getMessage());
		}
	}
}
