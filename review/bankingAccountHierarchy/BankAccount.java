package bankingAccountHierarchy;

abstract class BankAccount {
	final String accountNumber;
	private String holderName;
	private double balance;

	BankAccount(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String getholderName() {
		return holderName;
	}

	abstract double calculateFee();
}
