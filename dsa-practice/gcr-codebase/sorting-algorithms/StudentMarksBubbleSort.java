import java.util.Arrays;

public class StudentMarksBubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// Swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 52, 64, 98, 45, 76, 28, 69, 82, 49, 78 };
		bubbleSort(arr);
		System.out.println("Ascending order: " + Arrays.toString(arr));
	}
}
