
import java.util.*;

public class RotateList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		int k = 2;

		rotate(list, k);
		System.out.println(list);
	}

	static void rotate(List<Integer> list, int k) {
		k = k % list.size();

		List<Integer> temp = new ArrayList<>();

		for (int i = k; i < list.size(); i++) {
			temp.add(list.get(i));
		}

		for (int i = 0; i < k; i++) {
			temp.add(list.get(i));
		}

		list.clear();
		list.addAll(temp);
	}
}
