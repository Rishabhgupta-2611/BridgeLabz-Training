//Write a program to print multiplication table of a given number n.//
import java.util.Scanner;
public class nMultiplicationTable {
    public static void main(String[] args) {
        System.out.println("ENTER THE NUMBER");
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.printf("%d X %d = %d\n",n,i,n*i);
            Sc.close();

        }
    }
    
}
