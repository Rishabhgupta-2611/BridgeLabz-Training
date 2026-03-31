//Write a program to find factorial of a given number using for loop.//
import java.util.Scanner;
class nFactorialNumber {
    public static void main(String[] args) {
        System.out.println("ENTER THE NUMBER");
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact = fact * i;
            Sc.close();
        }
        System.out.print("FACTORIAL OF NUMBER IS:");
        System.out.println(fact);

    }
    
}
