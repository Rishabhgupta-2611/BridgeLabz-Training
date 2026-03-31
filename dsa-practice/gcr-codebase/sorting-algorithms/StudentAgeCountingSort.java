import java.util.Arrays;

public class StudentAgeCountingSort {

	public static void countingSort(int[] ages) {
		int min = 10;
		int max = 18;
		int range = max - min + 1;
		int[] count = new int[range];
		int[] output = new int[ages.length];
		for (int age : ages) {
			count[age - min]++;
		}

		for (int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}

		for (int i = ages.length - 1; i >= 0; i--) {
			output[count[ages[i] - min] - 1] = ages[i];
			count[ages[i] - min]--;
		}

		for (int i = 0; i < ages.length; i++) {
			ages[i] = output[i];
		}
	}

	public static void main(String[] args) {

		int[] studentAges = { 15, 12, 18, 10, 14, 12, 16, 15 };

		countingSort(studentAges);

		System.out.println("Counting Sort:");
		System.out.println(Arrays.toString(studentAges));
	}
}
