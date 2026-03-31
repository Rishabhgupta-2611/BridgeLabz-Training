package onlineBankingSystem;

class CurrentAccount extends Account {
	CurrentAccount(int accountNumber, String accountHolderName, double balance) {
		super(accountNumber, accountHolderName, balance);
	}

	@Override
	double calculateInterest() {
		return balance * 0.02;
	}
}
