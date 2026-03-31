package employeewagecomputation;
import java.util.*;

public class EmployeeWage {

	static final int IS_ABSENT = 0;
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;
    
	// UC - 2 & 3
	static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    
    // UC -  5 & 6
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;
    
    Random random = new Random();
    ArrayList<Integer> dailyWageList = new ArrayList<>();
    
    // UC - 1: Check Attendance
    int getAttendance() {
        return random.nextInt(2); // 0 = Absent, 1 = Present
    }
    
    // Calculation using Switch
    int getDailyWage(int employeeType) {
        int workingHours;

        switch (employeeType) {
            case IS_FULL_TIME:
                workingHours = FULL_DAY_HOURS;
                break;

            case IS_PART_TIME:
                workingHours = PART_TIME_HOURS;
                break;

            default:
                workingHours = 0;
        }
        return workingHours * WAGE_PER_HOUR;
    }
    
    //Monthly Wage Calculation
    void calculateMonthlyWage() {
        int totalDays = 0;
        int totalHours = 0;
        int totalSalary = 0;

        while (totalDays < MAX_WORKING_DAYS && totalHours < MAX_WORKING_HOURS) {

            totalDays++;
            int employeeType = random.nextInt(3); // 0,1,2

            int dailyWage = getDailyWage(employeeType);
            int hoursWorked = dailyWage / WAGE_PER_HOUR;

            totalHours += hoursWorked;
            totalSalary += dailyWage;
            dailyWageList.add(dailyWage);

            System.out.println("Day " + totalDays +"  | Hours Worked: " + hoursWorked +"  | Daily Wage: " + dailyWage);
        }

        System.out.println("\nTotal Working Days : " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Monthly Wage : " + totalSalary);
    }
}
