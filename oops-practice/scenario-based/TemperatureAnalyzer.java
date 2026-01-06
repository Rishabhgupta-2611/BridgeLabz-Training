public class TemperatureAnalyzer {

	public static float[] analyzeTemperatures(float[][] temperatures) {

		float[] dailyAverages = new float[7];

		float maxAvg = Float.MIN_VALUE;
		float minAvg = Float.MAX_VALUE;

		int hottestDay = 0;
		int coldestDay = 0;

		for (int day = 0; day < 7; day++) {
			float sum = 0;
			for (int hour = 0; hour < 24; hour++) {
				sum += temperatures[day][hour];
			}
			float average = sum / 24;
			dailyAverages[day] = average;

			if (average > maxAvg) {
				maxAvg = average;
				hottestDay = day;
			}

			if (average < minAvg) {
				minAvg = average;
				coldestDay = day;
			}
		}

		System.out.println("Hottest Day: Day " + (hottestDay + 1));
		System.out.println("Coldest Day: Day " + (coldestDay + 1));

		return dailyAverages;
	}

	public static void main(String[] args) {
		float[][] temperatures = new float[7][24];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 24; j++) {
				temperatures[i][j] = 20 + i;
			}
		}
		float[] averages = analyzeTemperatures(temperatures);

		System.out.println("Average Temperatures:");
		for (int i = 0; i < averages.length; i++) {
			System.out.println("Day " + (i + 1) + ": " + averages[i]);
		}
	}
}
