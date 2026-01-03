class Employee {
	private String name;
	private String id;
	private double salary;

	Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	void displayDetails() {
		System.out.println("Name: " + name);
		System.out.println("Employee Id: " + id);
		System.out.println("Salary: " + salary);
	}
}

class Manager extends Employee {
	private int teamSize;

	Manager(String name, String id, double salary, int teamSize) {
		super(name, id, salary);
		this.teamSize = teamSize;
	}

	void displayDetails() {
		super.displayDetails();
		System.out.println("Team Size: " + teamSize);
	}
}

class Developer extends Employee {
	private String programmingLanguage;

	Developer(String name, String id, double salary, String programmingLanguage) {
		super(name, id, salary);
		this.programmingLanguage = programmingLanguage;
	}

	void displayDetails() {
		super.displayDetails();
		System.out.println("Programming Language: " + programmingLanguage);
	}
}

class Intern extends Employee {
	Intern(String name, String id, double salary) {
		super(name, id, salary);
	}

	void displayDetails() {
		super.displayDetails();
	}
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Employee e1 = new Manager("Rishabh", "E001", 28000, 5);
		Employee e2 = new Developer("Aryan", "D006", 32000, "Java");
		Employee e3 = new Intern("Kuldeep", "I008", 10000);

		e1.displayDetails();
		System.out.println("-------------------------------------");
		e2.displayDetails();
		System.out.println("-------------------------------------");
		e3.displayDetails();
		System.out.println("-------------------------------------");
	}
}
