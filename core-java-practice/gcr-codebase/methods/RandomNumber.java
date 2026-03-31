import java.util.Arrays;

public class RandomNumber {

	public static void main(String[] args) {
		RandomNumber obj = new RandomNumber();

		int[] numbers = obj.generate4DigitRandomArray(5);
		double[] result = obj.findAverageMinMax(numbers);

		System.out.println(Arrays.toString(numbers));
		System.out.println("Average: " + result[0]);
		System.out.println("Minimum: " + result[1]);
		System.out.println("Maximum: " + result[2]);
	}

	public int[] generate4DigitRandomArray(int size) {
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = (int) (Math.random() * 9000) + 1000;
		}
		return arr;
	}

	public double[] findAverageMinMax(int[] numbers) {
		int min = numbers[0];
		int max = numbers[0];
		int sum = 0;

		for (int n : numbers) {
			sum += n;
			min = Math.min(min, n);
			max = Math.max(max, n);
		}

		double average = (double) sum / numbers.length;
		return new double[] { average, min, max };
	}
}
