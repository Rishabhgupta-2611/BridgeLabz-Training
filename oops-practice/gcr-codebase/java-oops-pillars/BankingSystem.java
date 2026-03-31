interface Loanable {
	void applyForLoan(double amount);

	void calculateLoanEligibility();
}

abstract class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;

	BankAccount(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
		} else {
			System.out.println("Invalid withdrawal amount.");
		}
	}

	public abstract double calculateInterest();

	public void displayAccountInfo() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Holder Name: " + holderName);
		System.out.println("Balance: " + balance);
	}
}

class SavingsAccount extends BankAccount implements Loanable {

	public SavingsAccount(String accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	@Override
	public double calculateInterest() {
		return getBalance() * 0.05;
	}

	@Override
	public void applyForLoan(double amount) {
		System.out.println("Savings Account loan applied for: " + amount);
	}

	@Override
	public void calculateLoanEligibility() {
		System.out.println("Loan Eligibility: " + (getBalance() * 3));
	}
}

class CurrentAccount extends BankAccount implements Loanable {

	public CurrentAccount(String accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	@Override
	public double calculateInterest() {
		return getBalance() * 0.02;
	}

	@Override
	public void applyForLoan(double amount) {
		System.out.println("Current Account loan applied for: " + amount);
	}

	@Override
	public void calculateLoanEligibility() {
		System.out.println("Loan Eligibility: " + (getBalance() * 5));
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		BankAccount[] accounts = { new SavingsAccount("SA101", "John Doe", 1000),
				new CurrentAccount("CA201", "Jane Doe", 2000) };

		for (BankAccount acc : accounts) {
			acc.displayAccountInfo();
			System.out.println("Interest: " + acc.calculateInterest());
			Loanable loan = (Loanable) acc;
			loan.applyForLoan(5000);
			loan.calculateLoanEligibility();
			System.out.println("-------------------------");
		}
	}
}
