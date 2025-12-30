
public class Student {

	String name;
	String rollNumber;
	double mark1, mark2, mark3;

	Student(String name, String rollNumber, double mark1, double mark2, double mark3) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}

	void displayReport() {
		double average = (mark1 + mark2 + mark3) / 3;
		char grade;

		if (average >= 75)
			grade = 'B';
		else
			grade = 'C';

		System.out.println("Student Name: " + name);
		System.out.println("Student RollNumber: " + rollNumber);
		System.out.println("Student Marks:");
		System.out.println("Mark1: " + mark1);
		System.out.println("Mark2: " + mark2);
		System.out.println("Mark3: " + mark3);
		System.out.println("Grade " + grade);
	}

	public static void main(String[] args) {
		Student s1 = new Student("Thamarai", "ECE001", 80, 70, 75);
		Student s2 = new Student("Kannan", "CSC002", 60, 65, 50);

		s1.displayReport();
		s2.displayReport();
	}
}
