import java.util.*;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int principal = sc.nextInt();
        int rate = sc.nextInt();
        int time = sc.nextInt();
        int interest = (principal * rate * time) / 100; // Formula: S.I = (P*R*T) / 100
        System.out.println("Simple Interest is " + interest);
        sc.close();
    }
    
}
