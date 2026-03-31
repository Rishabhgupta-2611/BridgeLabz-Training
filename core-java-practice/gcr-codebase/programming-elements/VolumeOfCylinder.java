import java.util.Scanner;
public class VolumeOfCylinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of cylinder: ");
        double r = sc.nextDouble();
        System.out.print("Enter height of cylinder: ");
        double h = sc.nextDouble();
        double vol = Math.PI * r * r * h; // Calculate volume using Math.PI
        System.out.println("Volume of cylinder = " + vol);
        sc.close();

	}
}
