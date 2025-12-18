import java.util.*;

/**
 * Program to convert kilometers to miles
 * Formula: miles = km / 1.60934
 */
public class UserInputKmToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        
        // More precise conversion factor
        double miles = km / 1.60934;
        
        System.out.println("The total miles is " + miles + " miles for the given " + km + " km");
        
        sc.close();
    }
}
