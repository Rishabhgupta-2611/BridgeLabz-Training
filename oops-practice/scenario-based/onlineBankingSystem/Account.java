package onlineBankingSystem;

import java.util.ArrayList;
import java.util.List;

abstract class Account {

	protected int accountNumber;
	protected String accountHolderName;
	protected double balance;
	protected List<String> transactions = new ArrayList<>();

	Account(int accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public synchronized void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount");
			return;
		}
		balance += amount;
		transactions.add("Deposited: " + amount);
		System.out.println("Amount Deposited: " + amount);
	}

	public synchronized void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new InsufficientBalanceException("Invalid withdrawal amount");
		}
		if (balance < amount) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		balance -= amount;
		transactions.add("Withdraw: " + amount);
		System.out.println("Amount Withdraw: " + amount);
	}

	public synchronized void fundTransfer(Account otherAccount, double amount) throws InsufficientBalanceException {

		this.withdraw(amount);
		otherAccount.deposit(amount);
		transactions.add("Fund Transfer: " + amount + " to " + otherAccount.accountNumber);
	}

	public void checkBalance() {
		System.out.println("Balance: " + balance);
	}

	public synchronized void transactionHistory() {
		System.out.println("Transaction History:");
		for (String t : transactions) {
			System.out.println(t);
		}
	}

	abstract double calculateInterest();
}
