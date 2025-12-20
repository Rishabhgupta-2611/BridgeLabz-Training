import java.util.*;

public class BMIUsing2DArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		double[][] personData = new double[number][3]; // height, weight, BMI
		String[] weightStatus = new String[number];

		for (int i = 0; i < number; i++) {
			double height = sc.nextDouble();
			double weight = sc.nextDouble();

			if (height <= 0 || weight <= 0) {
				i--;
				continue;
			}

			personData[i][0] = height;
			personData[i][1] = weight;
			personData[i][2] = weight / (height * height);

			if (personData[i][2] <= 18.4) {
				weightStatus[i] = "Underweight";
			} else if (personData[i][2] <= 24.9) {
				weightStatus[i] = "Normal";
			} else if (personData[i][2] <= 39.9) {
				weightStatus[i] = "Overweight";
			} else {
				weightStatus[i] = "Obese";
			}

		}

		for (int i = 0; i < number; i++) {
			System.out.println("Height: " + personData[i][0]);
			System.out.println("Weight: " + personData[i][1]);
			System.out.println("BMI: " + personData[i][2]);
			System.out.println("Status: " + weightStatus[i]);
		}

		sc.close();
	}
}
