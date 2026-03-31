import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] person = new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				person[i][j] = sc.nextInt();
				
 			}
		}
		sc.close();
		
		

	}

}
