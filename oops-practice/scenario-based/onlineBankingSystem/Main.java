package onlineBankingSystem;

public class Main {
	public static void main(String[] args) {

		Account acc1 = new SavingsAccount(101, "Rishabh", 5000);
		Account acc2 = new CurrentAccount(102, "Aman", 3000);

		acc1.deposit(2000);
		acc1.checkBalance();

		try {
			acc1.fundTransfer(acc2, 1500);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

		TransactionThread t1 = new TransactionThread(acc1, 2000);
		TransactionThread t2 = new TransactionThread(acc1, 3000);

		t1.start();
		t2.start();

		acc1.transactionHistory();
		acc2.transactionHistory();

		System.out.println("Interest (Savings): " + acc1.calculateInterest());
		System.out.println("Interest (Current): " + acc2.calculateInterest());
	}
}
