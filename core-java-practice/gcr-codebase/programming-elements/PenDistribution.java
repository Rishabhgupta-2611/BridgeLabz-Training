
public class PenDistribution {
	public static void main(String[] args) {
		int totalPens = 14;
        int st = 3;
        int eachPens = totalPens / st;
        int remainingPens = totalPens % st;
        
        System.out.println("The Pen Per Student is "+ eachPens + " and the remaining pen not distributed is "+remainingPens);
	}

}
