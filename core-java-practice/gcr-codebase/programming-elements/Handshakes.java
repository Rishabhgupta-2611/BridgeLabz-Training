import java.util.*;

public class Handshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of students: ");
        int numOfStudents = sc.nextInt();

        int handshakes = (numOfStudents * (numOfStudents - 1)) / 2;

        System.out.println("The maximum no. of handshakes is: " + handshakes);
        
        sc.close();
	}

}
