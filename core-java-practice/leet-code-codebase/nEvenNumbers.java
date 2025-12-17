1//Write a program to sum the first n even numbers using While loop.//
import java.util.Scanner;
public class nEvenNumbers {
    public static void main(String[] args) {
        System.out.println("ENTER THE NUMBER");
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + (2*i);
        }
        System.out.print("THE SUM OF EVEN NUMBERS IS: ");
        System.out.println(sum);
        Sc.close();


        
    }
    
}
