package bankingAccountHierarchy;

public class BankingApp {

	public static void main(String[] args) {
		BankAccount savings = new SavingsAccount("12345", "Rishabh", 1000.0);
		System.out.printf("%.2f", savings.calculateFee());

	}

}
