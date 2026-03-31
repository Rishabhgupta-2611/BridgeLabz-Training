import java.util.*;

public class LongestConsecutive {

	public static int longestSeq(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr)
			set.add(num);

		int max = 0;

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int current = num;
				int count = 1;

				while (set.contains(current + 1)) {
					current++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };

		System.out.println(longestSeq(arr));
	}
}
