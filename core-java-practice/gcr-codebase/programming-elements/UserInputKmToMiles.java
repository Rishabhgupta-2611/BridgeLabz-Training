import java.util.*;
public class UserInputKmToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        double miles = km / 1.6; // Conversion Factor
        
        System.out.println("The total miles is " + miles + " miles for the given " + km + " km");
        
        sc.close();
    }
}
