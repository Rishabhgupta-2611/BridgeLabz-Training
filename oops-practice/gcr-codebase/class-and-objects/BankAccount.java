
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
		BankAccount acc = new BankAccount();

		acc.displayBalance();
		acc.deposit(200);
		acc.displayBalance();
		acc.withdraw(100);
		acc.displayBalance();
		acc.withdraw(900);
	}
}
