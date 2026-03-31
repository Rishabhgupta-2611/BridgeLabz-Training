import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] data = new double[10][3];

		for (int i = 0; i < 10; i++) {
			data[i][0] = sc.nextDouble();
			data[i][1] = sc.nextDouble();
		}

		calculateBMI(data);
		String[] status = getBMIStatus(data);

		for (int i = 0; i < 10; i++) {
			System.out.println("Height: " + data[i][1] + " Weight: " + data[i][0] + " BMI: " + data[i][2] + " Status: "
					+ status[i]);
		}
		sc.close();
	}

	static void calculateBMI(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			double heightInMeters = arr[i][1] / 100;
			arr[i][2] = arr[i][0] / (heightInMeters * heightInMeters);
		}
	}

	static String[] getBMIStatus(double[][] arr) {
		String[] status = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			double bmi = arr[i][2];

			if (bmi < 18.5) {
				status[i] = "Underweight";
			} else if (bmi < 25) {
				status[i] = "Normal";
			} else if (bmi < 30) {
				status[i] = "Overweight";
			} else {
				status[i] = "Obese";
			}
		}
		return status;
	}
}
