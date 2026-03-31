import java.util.Scanner;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the size: ");
			int size = sc.nextInt();
			int[] arr = null; // array declared but not initialized

			if (size > 0) {
				arr = new int[size]; // initialized only if size > 0
			}
			System.out.println("Enter the elements of Array: ");
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println("Enter the index: ");
			int index = sc.nextInt();

			System.out.println("Value at index " + index + " : " + arr[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index!");
		} catch (NullPointerException e) {
			System.out.println("Array is not initialized!");
		} finally {
			sc.close();
		}

	}
}
