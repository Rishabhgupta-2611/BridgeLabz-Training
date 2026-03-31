import java.util.*;

public class SearchDSComparison {

	public static void main(String[] args) {

		int[] sizes = { 1000, 100000, 1000000 };

		for (int size : sizes) {

			int[] array = new int[size];
			HashSet<Integer> hashSet = new HashSet<>();
			TreeSet<Integer> treeSet = new TreeSet<>();

			for (int i = 0; i < size; i++) {
				array[i] = i;
				hashSet.add(i);
				treeSet.add(i);
			}

			int target = size - 1;
			long start, end;

			// Array search
			start = System.nanoTime();
			for (int i = 0; i < array.length; i++) {
				if (array[i] == target)
					break;
			}
			end = System.nanoTime();
			System.out.println("Array Search (" + size + "): " + (end - start) / 1_000_000 + " ms");

			// HashSet search
			start = System.nanoTime();
			hashSet.contains(target);
			end = System.nanoTime();
			System.out.println("HashSet Search (" + size + "): " + (end - start) / 1_000_000 + " ms");

			// TreeSet search
			start = System.nanoTime();
			treeSet.contains(target);
			end = System.nanoTime();
			System.out.println("TreeSet Search (" + size + "): " + (end - start) / 1_000_000 + " ms");

			System.out.println("--------------------------------");
		}
	}
}
