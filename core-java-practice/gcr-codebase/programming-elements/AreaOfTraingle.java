import java.util.*;
public class AreaOfTraingle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base: ");
		double base = sc.nextDouble();
		System.out.print("Enter the height: ");
		double height = sc.nextDouble();
		double area_in_cm = 0.5 * base * height;
        double area_in_Inch = area_in_cm / (2.54 * 2.54);
        System.out.println("Area of triangle in square inches is: " + area_in_Inch + " and in square centimetres is: " + area_in_cm);
        sc.close();
	}

}
