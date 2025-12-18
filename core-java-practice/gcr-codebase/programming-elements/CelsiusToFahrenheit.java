import java.util.Scanner;
public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9.0 / 5.0) + 32; //Formula: F = (C × 9/5) + 32
        System.out.println(celsius + " C = " + fahrenheit + " F");
        sc.close();
        
	}

}
