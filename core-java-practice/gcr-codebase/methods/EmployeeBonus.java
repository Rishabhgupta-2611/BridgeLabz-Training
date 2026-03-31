
public class EmployeeBonus {

	public static void main(String[] args) {
		double[][] employeeData = generateEmployeeData();
		double[][] updatedData = calculateBonusAndNewSalary(employeeData);
		displaySalaryDetails(employeeData, updatedData);
	}

	public static double[][] generateEmployeeData() {
		double[][] data = new double[10][2];

		for (int i = 0; i < 10; i++) {
			data[i][0] = (int) (Math.random() * 90000) + 10000; // 5-digit salary
			data[i][1] = (int) (Math.random() * 10) + 1; // 1 to 10 years
		}
		return data;
	}

	public static double[][] calculateBonusAndNewSalary(double[][] data) {
		double[][] result = new double[10][2];

		for (int i = 0; i < 10; i++) {
			double salary = data[i][0];
			double years = data[i][1];
			double bonus;

			if (years > 5)
				bonus = salary * 0.05;
			else
				bonus = salary * 0.02;

			result[i][1] = bonus;
			result[i][0] = salary + bonus;
		}
		return result;
	}

	public static void displaySalaryDetails(double[][] oldData, double[][] newData) {

		double totalOldSalary = 0;
		double totalNewSalary = 0;
		double totalBonus = 0;

		System.out.println("Emp  OldSalary  Years  Bonus   NewSalary");
		System.out.println("-----------------------------------------");

		for (int i = 0; i < 10; i++) {
			double oldSalary = oldData[i][0];
			double years = oldData[i][1];
			double bonus = newData[i][1];
			double newSalary = newData[i][0];

			totalOldSalary += oldSalary;
			totalNewSalary += newSalary;
			totalBonus += bonus;

			System.out.println((i + 1) + "   " + Math.round(oldSalary) + "     " + Math.round(years) + "    "
					+ Math.round(bonus) + "    " + Math.round(newSalary));
		}

		System.out.println("-----------------------------------------");
		System.out.println("Total Old Salary : " + totalOldSalary);
		System.out.println("Total Bonus Paid : " + totalBonus);
		System.out.println("Total New Salary : " + totalNewSalary);
	}
}
