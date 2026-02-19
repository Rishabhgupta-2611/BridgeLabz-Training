package junittestcase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

	@Test
	public void Test_Deposit_ValidAmount() {
		try {
			BankAccount p = new BankAccount(10000);
			p.deposit(5000);
			assertEquals(p.getbalance(), 15000);
		} catch (BankException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void Test_Deposit_NegativeAmount() {
		BankAccount p = new BankAccount(10000);
		assertEquals("Deposit amount cannot be negative",
				assertThrows(BankException.class, () -> p.deposit(-5000)).getMessage());
	}

	@Test
	public void Test_Withdraw_ValidAmount() {
		try {
			BankAccount p = new BankAccount(10000);
			p.withdraw(5000);
			assertEquals(p.getbalance(), 5000);
		} catch (BankException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void Test_Withdraw_InsufficientFunds() {
		BankAccount p = new BankAccount(10000);
		assertEquals("Insufficient funds.", assertThrows(BankException.class, () -> p.withdraw(15000)).getMessage());
	}

}
