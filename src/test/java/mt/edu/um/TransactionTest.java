package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
	private Transaction transaction;
	AccountDatabase database = new AccountDatabase();
	final Account acc1 = new Account(1, "Fixed", 6000);
	final Account acc2 = new Account(2, "Savings", 4500);
	
	@Test 
	public void processTest1() {
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transaction = new Transaction(1, 2, 4000);
		boolean actual = transaction.process();
		Assert.assertEquals(true, actual);
	}
	
	@Test // invalid source account
	public void processTest2() {
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transaction = new Transaction(3, 1, 4000);
		Assert.assertEquals(false, transaction.process());
	}
	
	@Test // invalid destination account
	public void processTest3() {
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transaction = new Transaction(1, 3, 4000);
		Assert.assertEquals(false, transaction.process());
	}
	
	@Test // insufficient balance
	public void processTest4() {
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transaction = new Transaction(1, 2, 8000);
		Assert.assertEquals(false, transaction.process());
	}
	
	
	@Test
	public void setSourceAccountNumberTest(){
		transaction = new Transaction();
		int expected = 120;
		transaction.setSourceAccountNumber(expected);
		Assert.assertEquals(expected, transaction.getSourceAccountNumber());
	}
	
	@Test
	public void setDestinationAccountNumberTest(){
		transaction = new Transaction();
		int expected = 155;
		transaction.setDestinationAccountNumber(expected);
		Assert.assertEquals(expected, transaction.getDestinationAccountNumber());
	}
	
	@Test
	public void setAmountTest(){
		transaction = new Transaction();
		long expected = 10000;
		transaction.setAmount(expected);
		Assert.assertEquals(expected, transaction.getAmount());
	}
	
	@Test
	public void getSourceAccountNumberTest(){
		transaction = new Transaction();
		int expected = 40000;
		transaction.setSourceAccountNumber(expected);
		Assert.assertTrue(transaction.getSourceAccountNumber() == expected);
	}
	
	@Test
	public void getDestinationAccountNumberTest(){
		transaction = new Transaction();
		int expected = 20000;
		transaction.setDestinationAccountNumber(expected);
		Assert.assertTrue(transaction.getDestinationAccountNumber() == expected);
	}
	
	@Test
	public void getAmountTest(){
		transaction = new Transaction();
		int expected = 3000;
		transaction.setAmount(expected);
		Assert.assertTrue(transaction.getAmount() == expected);
	}
	

}
