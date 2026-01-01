
public class Employee {

	private static String companyName = "Tech Solutions Inc.";
	private static int totalEmployee = 0;

	public static void displayTotalEmployees() {
		System.out.println("Total Employees: " + totalEmployee);
	}

	private final int id;
	private String name;
	private String designation;

	Employee(int id, String name, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		totalEmployee++;
	}

	public void displayEmployeeDetails() {
		if (this instanceof Employee) {
			System.out.println("Company Name: " + companyName);
			System.out.println("Employee Id: " + id);
			System.out.println("Name: " + name);
			System.out.println("Designation: " + designation);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Thamarai", "Software Engineer");
		Employee e2 = new Employee(102, "Rohan", "Project Manager");
		Employee.displayTotalEmployees();
		e1.displayEmployeeDetails();
		e2.displayEmployeeDetails();

	}

}
