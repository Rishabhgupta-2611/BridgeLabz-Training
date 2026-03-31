
import java.util.*;
public class YoungestFriends {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	    System.out.println("Enter ages of Amar, Akbar, Anthony: ");
	    int age1 = sc.nextInt();
	    int age2 = sc.nextInt();
	    int age3 = sc.nextInt();

	    System.out.println("Enter heights of Amar, Akbar, Anthony: ");
	    int height1 = sc.nextInt();
	    int height2 = sc.nextInt();
	    int height3 = sc.nextInt();

	    
	    int youngest = age1; // Youngest
	    if (age2 < youngest) {
	    	youngest = age2;
	    }
	    if (age3 < youngest) {
	    	youngest = age3;
	    }
	    System.out.println("Youngest age: " + youngest);

	    
	    int tallest = height1; // Tallest
	    if (height2 > tallest) {
	    	tallest = height2;
	    }
	    if (height3 > tallest) {
	    	tallest = height3;
	    }
	    System.out.println("Tallest height: " + tallest);

	    sc.close();
	}

}
