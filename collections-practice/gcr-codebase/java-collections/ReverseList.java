
import java.util.*;

public class ReverseList {

	static void reverseList(List<Integer> list) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			Integer temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);

			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		reverseList(list);
		System.out.println(list);
	}

}
