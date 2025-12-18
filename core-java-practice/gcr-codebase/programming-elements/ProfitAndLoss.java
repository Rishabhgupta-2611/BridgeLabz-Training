
public class ProfitAndLoss {

	public static void main(String[] args) {
		double costPrice = 129.0;
		double sellingPrice = 191.0;
		double profit = sellingPrice - costPrice; // Formula: Profit = SP-CP
		double profitPercentage = profit / costPrice * 100; // Formula: Profit% = Profit / CP * 100
		System.out.println("The Cost Price in INR " + costPrice + " and Selling Price in INR " + sellingPrice);
		System.out.println("The Profit in INR " + profit + " and the Profit Percentage is " + profitPercentage);
				

	}

}
