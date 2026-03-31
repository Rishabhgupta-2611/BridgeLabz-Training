
public class Employee {

	public int employeeID;
	protected String department;
	private double salary;

	Employee(int employeeID, String department, double salary) {
		this.employeeID = employeeID;
		this.department = department;
		this.salary = salary;
	}

	public void setSalary(double salary) { // Public method to modify salary
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
}

class Manager extends Employee { // Subclass

	Manager(int employeeID, String department, double salary) {
		super(employeeID, department, salary);
	}

	void displayDetails() {
		System.out.println("Employee ID: " + employeeID); // public
		System.out.println("Department: " + department); // protected
		System.out.println("Salary: " + getSalary()); // private via method
	}

	public static void main(String[] args) {
		Manager mgr = new Manager(501, "IT", 75000);
		mgr.displayDetails();
	}
}
