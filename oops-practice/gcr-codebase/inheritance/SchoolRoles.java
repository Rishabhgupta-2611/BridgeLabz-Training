class SchoolPerson {
	String name;
	int age;

	SchoolPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Teacher extends SchoolPerson {
	String subject;

	Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	void displayRole() {
		System.out.println("Teacher: " + name + ", Subject: " + subject);
	}
}

class Student extends SchoolPerson {
	String grade;

	Student(String name, int age, String grade) {
		super(name, age);
		this.grade = grade;
	}

	void displayRole() {
		System.out.println("Student: " + name + ", Grade: " + grade);
	}
}

class Staff extends SchoolPerson {
	String role;

	Staff(String name, int age, String role) {
		super(name, age);
		this.role = role;
	}

	void displayRole() {
		System.out.println("Staff: " + name + ", Role: " + role);
	}
}

public class SchoolRoles {
	public static void main(String[] args) {
		Teacher t = new Teacher("Alice", 34, "Mathematics");
		Student s = new Student("Bob", 15, "10th Grade");
		Staff st = new Staff("Carol", 45, "Secretary");

		t.displayRole();
		s.displayRole();
		st.displayRole();
	}
}