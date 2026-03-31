import java.util.*;

public class UserInputCourseFeeDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course fee (INR): ");
        int fee = sc.nextInt();
        System.out.print("Enter discount percentage: ");
        int discountPercent = sc.nextInt();
        int discount = (fee * discountPercent) / 100; //Formula: Discount = (fee * discount%) / 100
        int finalFee = fee - discount;
        
        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + finalFee);
        
        sc.close();
    }
}
