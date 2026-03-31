import java.util.*;

public class TrigonometricFunction {

	public static void calcTrigonometricFunction(double angle) {
		double radians = Math.toRadians(angle);

		double sine = Math.sin(radians);
		double cosine = Math.cos(radians);
		double tangent = Math.tan(radians);

		System.out.println("Sine: " + sine);
		System.out.println("Cosine: " + cosine);
		System.out.println("Tangent: " + tangent);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter angle in degrees: ");
		double angle = sc.nextDouble();

		calcTrigonometricFunction(angle);

		sc.close();
	}

}
