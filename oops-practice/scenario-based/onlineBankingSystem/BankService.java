package onlineBankingSystem;

interface BankService {
	void deposit(double amount);

	void withdraw(double amount) throws InsufficientBalanceException;

	void transfer(Account toAccount, double amount) throws InsufficientBalanceException;

	void checkBalance();
}
