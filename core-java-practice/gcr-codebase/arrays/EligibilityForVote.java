import java.util.*;

public class EligibilityForVote {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the age of 10 Students: ");

		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 18) {
				System.out.println("The Student with the age " + arr[i] + " can vote!");
			} else {
				System.out.println("The Student with the age " + arr[i] + " cannot vote!");
			}
		}
		sc.close();
	}

}
