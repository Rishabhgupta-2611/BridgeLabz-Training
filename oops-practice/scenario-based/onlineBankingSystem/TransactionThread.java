package onlineBankingSystem;

class TransactionThread extends Thread {
	private Account account;
	private double amount;

	public TransactionThread(Account account, double amount) {
		this.account = account;
		this.amount = amount;
	}

	public void run() {
		try {
			account.withdraw(amount);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
