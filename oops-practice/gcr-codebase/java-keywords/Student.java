public class Student {

	private static String universityName = "Global University";
	private static int totalStudents = 0;

	public static void displayTotalStudents() {
		System.out.println("Total Students Enrolled: " + totalStudents);
	}

	private final int rollNumber;
	private String name;
	private String grade;

	Student(int rollNumber, String name, String grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.grade = grade;
		totalStudents++;
	}

	public void displayStudentDetails() {
		if (this instanceof Student) {
			System.out.println("University Name: " + universityName);
			System.out.println("Roll Number: " + rollNumber);
			System.out.println("Name: " + name);
			System.out.println("Grade: " + grade);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public void updateGrade(String newGrade) {
		if (this instanceof Student) {
			this.grade = newGrade;
			System.out.println("Grade updated to: " + grade);
		}
	}

	public static void main(String[] args) {

		Student s1 = new Student(101, "Hemashree", "A");
		Student s2 = new Student(102, "Sharmila", "B");
		Student.displayTotalStudents();

		s1.displayStudentDetails();
		s2.displayStudentDetails();

		s2.updateGrade("A");
		s2.displayStudentDetails();
	}
}
