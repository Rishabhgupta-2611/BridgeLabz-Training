package onlineBankingSystem;

class SavingsAccount extends Account {
	SavingsAccount(int accountNumber, String accountHolderName, double balance) {
		super(accountNumber, accountHolderName, balance);
	}

	@Override
	double calculateInterest() {
		return balance * 0.04;
	}
}
