package employeewagecomputation;

public class Main {
	public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program\n");

        EmployeeWage employee = new EmployeeWage();

        // UC - 1: Execution
        if (employee.getAttendance() == 1) {
            System.out.println("Employee is Present\n");
        } else {
            System.out.println("Employee is Absent\n");
        }

        employee.calculateMonthlyWage();
    }
}
