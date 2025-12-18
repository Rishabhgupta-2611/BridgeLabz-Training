import java.util.*;
public class PerimeterOfSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the perimeter of Square is: ");
		int perimeter = sc.nextInt();
		double side = perimeter / 4;

		System.out.print("The length of the side is: " + side + " whose perimeter is: " + perimeter);
		sc.close();
	}

}
