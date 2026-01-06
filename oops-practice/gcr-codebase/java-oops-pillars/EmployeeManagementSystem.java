
interface Department {
	void assignDepartment(String deptName);

	String getDepartmentDetails();
}

abstract class Employee implements Department {
	private String employeeID;
	private String name;
	protected double baseSalary;
	private String department;

	Employee(String employeeID, String name, double baseSalary) {
		this.employeeID = employeeID;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public abstract double calculateSalary();

	public String getEmployeeId() {
		return employeeID;
	}

	public void setEmployeeId(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void assignDepartment(String deptName) {
		this.department = deptName;
	}

	@Override
	public String getDepartmentDetails() {
		return department;
	}

	public void displayDetails() {
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Salary: " + calculateSalary());
		System.out.println("-------------------------");
	}
}

class FullTimeEmployee extends Employee {
	FullTimeEmployee(String employeeID, String name, double baseSalary) {
		super(employeeID, name, baseSalary);
	}

	@Override
	public double calculateSalary() {
		return baseSalary;
	}
}

class PartTimeEmployee extends Employee {

	int workHours;
	int perHour;

	PartTimeEmployee(String employeeID, String name, int perHour, int workHours) {
		super(employeeID, name, 0);
		this.workHours = workHours;
		this.perHour = perHour;
	}

	@Override
	public double calculateSalary() {
		return workHours * perHour;

	}
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {

		Employee e1 = new FullTimeEmployee("E101", "Rohit", 50000);
		Employee e2 = new PartTimeEmployee("E102", "Aman", 20, 500);
		e1.assignDepartment("IT");
		e2.assignDepartment("HR");

		e1.displayDetails();
		e2.displayDetails();

	}

}
