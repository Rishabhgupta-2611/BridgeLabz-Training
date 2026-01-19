package bankingAccountHierarchy;

class SavingsAccount extends BankAccount {
	public SavingsAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	double calculateFee() {
		return getBalance() * 0.005;
	}
}
