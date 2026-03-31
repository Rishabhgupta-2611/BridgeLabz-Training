
public class BankAccount {

	public int accountNumber;
	protected String accountHolder;
	private double balance;

	BankAccount(int accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public double getBalance() { // Public methods for private balance
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

class SavingsAccount extends BankAccount { // Subclass

	SavingsAccount(int accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
	}

	void displayAccount() {
		System.out.println("Account Number: " + accountNumber); // public
		System.out.println("Account Holder: " + accountHolder); // protected
		System.out.println("Balance: " + getBalance()); // private via method
	}

	public static void main(String[] args) {
		SavingsAccount acc = new SavingsAccount(12345, "Rishabh", 50000);
		acc.displayAccount();
	}
}
