import java.util.Scanner;

public class StudentGradeCalculator2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int n = sc.nextInt();

		int[][] marks = new int[n][3];
		double[] percentage = new double[n];
		char[] grade = new char[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter marks for Student " + (i + 1));

			System.out.print("Physics: ");
			marks[i][0] = sc.nextInt();
			if (marks[i][0] < 0) {
				System.out.println("Marks must be positive. Re-enter student details.");
				i--;
				continue;
			}

			System.out.print("Chemistry: ");
			marks[i][1] = sc.nextInt();
			if (marks[i][1] < 0) {
				System.out.println("Marks must be positive. Re-enter student details.");
				i--;
				continue;
			}

			System.out.print("Maths: ");
			marks[i][2] = sc.nextInt();
			if (marks[i][2] < 0) {
				System.out.println("Marks must be positive. Re-enter student details.");
				i--;
				continue;
			}

			percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

			if (percentage[i] >= 90)
				grade[i] = 'A';
			else if (percentage[i] >= 75)
				grade[i] = 'B';
			else if (percentage[i] >= 60)
				grade[i] = 'C';
			else if (percentage[i] >= 40)
				grade[i] = 'D';
			else
				grade[i] = 'F';
		}

		System.out.println("Student Details:");
		for (int i = 0; i < n; i++) {
			System.out.println("Student " + (i + 1));
			System.out.println("Physics: " + marks[i][0]);
			System.out.println("Chemistry: " + marks[i][1]);
			System.out.println("Maths: " + marks[i][2]);
			System.out.println("Percentage: " + percentage[i]);
			System.out.println("Grade: " + grade[i]);
		}

		sc.close();
	}
}
