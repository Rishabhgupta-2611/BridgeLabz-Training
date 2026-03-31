
class BankAccount {

	private String accountNumber;
	private double balance;

	BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful: " + amount);
		} else {
			System.out.println("Invalid deposit amount");
		}
	}

	void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount");
		} else if (amount > balance) {
			System.out.println("Insufficient balance");
		} else {
			balance -= amount;
			System.out.println("Withdrawal successful: " + amount);
		}
	}

	void checkBalance() {
		System.out.println("Current Balance: " + balance);
	}
}

public class BankAccountManager {

	public static void main(String[] args) {

		BankAccount account = new BankAccount("ACC12345", 5000);

		account.checkBalance();
		account.deposit(2000);
		account.withdraw(3000);
		account.withdraw(5000);
		account.checkBalance();
	}
}
