package junittestcase;

public class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) throws BankException {
		if (amount < 0) {
			throw new BankException("Deposit amount cannot be negative");
		}
		balance += amount;
	}

	public void withdraw(double amount) throws BankException {
		if (amount > balance) {
			throw new BankException("Insufficient funds.");
		}
		balance -= amount;
	}

}
