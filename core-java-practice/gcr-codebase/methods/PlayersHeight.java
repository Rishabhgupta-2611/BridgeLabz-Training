
public class PlayersHeight {

	public static int sumOfHeights(int heights[]) {
		int sum = 0;
		for (int h : heights) {
			sum += h;
		}
		return sum;
	}

	public static double meanHeight(int heights[]) {
		double mean = sumOfHeights(heights) / heights.length;
		return mean;
	}

	public static int findShortest(int heights[]) {
		int min = heights[0];
		for (int h : heights) {
			if (h < min) {
				min = h;
			}
		}
		return min;
	}

	public static int findTallest(int heights[]) {
		int max = heights[0];
		for (int h : heights) {
			if (h > max) {
				max = h;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int heights[] = new int[11];

		for (int i = 0; i < heights.length; i++) {
			heights[i] = (int) (Math.random() * 101) + 150;
		}

		for (int h : heights) {
			System.out.print(h + " ");
		}

		int sum = sumOfHeights(heights);
		double mean = meanHeight(heights);
		int shortest = findShortest(heights);
		int tallest = findTallest(heights);

		System.out.println("\nSum of Heights: " + sum);
		System.out.println("Mean Height: " + mean);
		System.out.println("Shortest Player Height: " + shortest);
		System.out.println("Tallest Player Height: " + tallest);

	}

}
