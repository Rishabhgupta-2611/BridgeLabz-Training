class BankAccount {
	String accountNumber;
	double balance;

	BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	void deposit(double amount) {
		balance += amount;
	}

	void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		}
	}
}

class SavingsAccount extends BankAccount {
	double interestRate;

	SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}

	void displayAccountType() {
		System.out.println("Savings Account - Interest Rate: " + interestRate);
	}
}

class CheckingAccount extends BankAccount {
	double withdrawalLimit;

	CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
		super(accountNumber, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	void displayAccountType() {
		System.out.println("Checking Account - Withdrawal Limit: " + withdrawalLimit);
	}
}

class FixedDepositAccount extends BankAccount {
	int tenureMonths;

	FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
		super(accountNumber, balance);
		this.tenureMonths = tenureMonths;
	}

	void displayAccountType() {
		System.out.println("Fixed Deposit Account - Tenure: " + tenureMonths + " months");
	}
}

public class BankAccountHierarchy {
	public static void main(String[] args) {
		SavingsAccount s = new SavingsAccount("SA1001", 5000.0, 3.5);
		CheckingAccount c = new CheckingAccount("CA2001", 1500.0, 1000.0);
		FixedDepositAccount f = new FixedDepositAccount("FD3001", 20000.0, 12);

		s.displayAccountType();
		System.out.println("Balance: " + s.balance);
		c.displayAccountType();
		System.out.println("Balance: " + c.balance);
		f.displayAccountType();
		System.out.println("Balance: " + f.balance);
	}
}