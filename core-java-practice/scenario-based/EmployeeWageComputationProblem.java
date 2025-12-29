import java.util.ArrayList;
import java.util.Random;

class EmployeeWage {

	// Constants
	static final int IS_ABSENT = 0;
	static final int IS_FULL_TIME = 1;
	static final int IS_PART_TIME = 2;

	static final int WAGE_PER_HOUR = 20;
	static final int FULL_DAY_HOUR = 8;
	static final int PART_TIME_HOUR = 4;

	static final int MAX_WORKING_DAYS = 20;
	static final int MAX_WORKING_HOURS = 100;

	Random random = new Random();
	ArrayList<Integer> dailyWages = new ArrayList<>();

	// UC1: Check Employee Attendance
	public int checkAttendance() {
		return random.nextInt(2); // 0 = Absent, 1 = Present
	}

	// UC2 & UC3 & UC4: Calculate Daily Wage using Switch Case
	public int calculateDailyWage(int empType) {
		int hoursWorked;

		switch (empType) {
		case IS_FULL_TIME:
			hoursWorked = FULL_DAY_HOUR;
			break;

		case IS_PART_TIME:
			hoursWorked = PART_TIME_HOUR;
			break;

		default:
			hoursWorked = 0;
		}
		return hoursWorked * WAGE_PER_HOUR;
	}

	// UC5 & UC6: Calculate Monthly Wage with Max Days & Hours
	public void calculateMonthlyWage() {

		int totalWorkingDays = 0;
		int totalWorkingHours = 0;
		int totalSalary = 0;

		while (totalWorkingDays < MAX_WORKING_DAYS && totalWorkingHours < MAX_WORKING_HOURS) {

			totalWorkingDays++;
			int empType = random.nextInt(3); // 0-Absent,1-Full,2-Part

			int dailyWage = calculateDailyWage(empType);
			int hoursWorked = dailyWage / WAGE_PER_HOUR;

			totalWorkingHours += hoursWorked;
			totalSalary += dailyWage;
			dailyWages.add(dailyWage);

			System.out.println(
					"Day " + totalWorkingDays + " | Hours Worked: " + hoursWorked + " | Daily Wage: " + dailyWage);
		}

		System.out.println("Total Working Days : " + totalWorkingDays);
		System.out.println("Total Working Hours: " + totalWorkingHours);
		System.out.println("Total Monthly Salary: ₹" + totalSalary);
	}
}

public class EmployeeWageComputationProblem {

	public static void main(String[] args) {

		System.out.println("Welcome to Employee Wage Computation Program");

		EmployeeWage employee = new EmployeeWage();

		// UC1: Attendance Check
		int attendance = employee.checkAttendance();
		if (attendance == 1) {
			System.out.println("Employee is Present");
		} else {
			System.out.println("Employee is Absent");
		}

		System.out.println("Calculating Monthly Wages");

		// UC4, UC5, UC6 Execution
		employee.calculateMonthlyWage();

		System.out.println("Thank You");
	}
}
