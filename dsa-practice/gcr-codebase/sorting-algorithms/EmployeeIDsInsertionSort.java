import java.util.Arrays;

public class EmployeeIDsInsertionSort {
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 101, 546, 963, 202, 445, 789, 852, 741, 456, 123 };
		insertionSort(arr);
		System.out.println("Ascending order: " + Arrays.toString(arr));

	}

}
