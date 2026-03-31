import java.util.Scanner;
public class AreaOfCircle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();        
        double area = Math.PI * radius * radius; //Calculate area using Math.PI for pi value
        System.out.println("Area of circle = " + area);
        sc.close();

	}

}
