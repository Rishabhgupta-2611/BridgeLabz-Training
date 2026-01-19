package bankingAccountHierarchy;

class CheckingAccount extends BankAccount {
	public CheckingAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	double calculateFee() {
		if (getBalance() < 1000) {
			return 1.0 * 100 * getBalance();
		} else {
			return 0.0;
		}
	}

}
