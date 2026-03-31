import java.util.*;

public class YardsandMilesDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter distance in feet: ");
		double dis= sc.nextDouble();
		
		double yar = dis / 3;
		double mil = yar / 1760;
		
		System.out.print("Distance in Yards is: " + yar + " and in miles is: " + mil);
		sc.close();
	}
}
