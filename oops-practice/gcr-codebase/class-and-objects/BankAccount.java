
public class BankAccount {

	double balance = 700.0;

	void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Deposited: " + amount);
	}

	void withdraw(double amount) {
		if (amount <= balance) {
			balance = balance - amount;
			System.out.println("Withdraw amount is : " + amount);
		} else {
			System.out.println("Insufficient balance");
		}
	}

	void displayBalance() {
		System.out.println("Current balance: " + balance);
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount();

		account.displayBalance();
		account.deposit(200);
		account.displayBalance();
		account.withdraw(100);
		account.displayBalance();
		account.withdraw(900);
	}
}
