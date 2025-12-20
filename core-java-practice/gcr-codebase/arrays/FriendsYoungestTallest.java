import java.util.Scanner;

public class FriendsYoungestTallest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] names = { "Amar", "Akbar", "Anthony" };
		double[] age = new double[3];
		double[] height = new double[3];

		for (int i = 0; i < 3; i++) {
			System.out.print(names[i] + " age: ");
			age[i] = sc.nextDouble();
			System.out.print(names[i] + " height: ");
			height[i] = sc.nextDouble();
		}

		int youngestIndex = 0;
		for (int i = 1; i < 3; i++) {
			if (age[i] < age[youngestIndex]) {
				youngestIndex = i;
			}
		}

		int tallestIndex = 0;
		for (int i = 1; i < 3; i++) {
			if (height[i] > height[tallestIndex]) {
				tallestIndex = i;
			}
		}

		System.out.println(names[youngestIndex] + " is youngest (age: " + age[youngestIndex] + ")");
		System.out.println(names[tallestIndex] + " is tallest (height: " + height[tallestIndex] + ")");

		sc.close();
	}
}
