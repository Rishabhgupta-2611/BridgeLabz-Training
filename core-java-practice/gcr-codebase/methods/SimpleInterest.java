import java.util.Scanner;

public class SimpleInterest {

	static double simpleInterest(double p, double r, double t) {
		double si = p * r * t / 100; // Simple Interest = Principal * Rate * Time / 100
		return si;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double principle = sc.nextDouble();
		float rate = sc.nextFloat();
		double time = sc.nextInt();
		double simpleInterest = simpleInterest(principle, rate, time);
		System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principle
				+ ", Rate of Interest " + rate + " and Time " + time);
		sc.close();

	}

}
