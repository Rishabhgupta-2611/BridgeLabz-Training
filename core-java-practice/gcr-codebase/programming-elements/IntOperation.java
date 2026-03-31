import java.util.*;
public class IntOperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter value a: ");
        int a = sc.nextInt();
        System.out.print("Enter value b: ");
        int b = sc.nextInt();
        System.out.print("Enter value c: ");
        int c = sc.nextInt();

        int r1 = a + b * c;
        int r2 = a * b + c;
        int r3 = c + a / b;
        int r4 = a % b + c;

        System.out.println("The results of Int Operations are: " + r1  + ", " + r2 + ", " + r3 + ", " + r4);
        
        sc.close();
	}

}
