import java.util.*;

public class HeightConvertor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter height in cm ");
		double heightInCm = sc.nextDouble();
		double inches = heightInCm / 2.54; // 1 inch = 2.54 cm
        double feet = inches / 12; // 1 foot = 12 inches
        System.out.println("Your Height in cm is " + heightInCm + "while in feet is " + feet + " and in inches is " + inches);
        sc.close();
	}
}
