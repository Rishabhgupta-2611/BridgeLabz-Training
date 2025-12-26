import java.util.Scanner;

public class FriendsComparison {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] names = { "Amar", "Akbar", "Anthony" };
		int[] ages = new int[3];
		double[] heights = new double[3];

		for (int i = 0; i < 3; i++) {
			ages[i] = sc.nextInt();
			heights[i] = sc.nextDouble();
		}

		int youngestIndex = findYoungest(ages);
		int tallestIndex = findTallest(heights);

		System.out.println("Youngest Friend: " + names[youngestIndex]);
		System.out.println("Tallest Friend: " + names[tallestIndex]);
		sc.close();
	}

	static int findYoungest(int[] ages) {
		int index = 0;
		for (int i = 1; i < ages.length; i++) {
			if (ages[i] < ages[index]) {
				index = i;
			}
		}
		return index;
	}

	static int findTallest(double[] heights) {
		int index = 0;
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[index]) {
				index = i;
			}
		}
		return index;
	}
}
