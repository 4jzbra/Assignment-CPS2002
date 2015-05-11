package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtomicTransactionTest {
	private AtomicTransaction transaction, transaction2;
	private AccountDatabase database;
	private Account acc1, acc2;
	
	@Before
	public void initialize(){
		database = new AccountDatabase();
		acc1 = new Account(1, "Fixed", 6000);
		acc2 = new Account(2, "Savings", 4500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transaction = new AtomicTransaction();
		transaction2 = new AtomicTransaction();
	}
	
	@Test 
	public void processTest1() {
		transaction = new AtomicTransaction(1, 2, 4000);
		Assert.assertEquals(true, transaction.process());
	}
	
	@Test (expected = NullPointerException.class) // invalid source account
	public void processTest2() {
		transaction = new AtomicTransaction(3, 1, 4000);
		transaction.process(); // this generates a NullPointerException
	}
	
	@Test (expected = NullPointerException.class) // invalid destination account
	public void processTest3() {
		transaction = new AtomicTransaction(1, 3, 4000);
		 transaction.process(); // this generates a NullPointerException
	}
	
	@Test (expected = IllegalArgumentException.class) // insufficient balance
	public void processTest4() {
		transaction = new AtomicTransaction(1, 2, 8000);
		transaction.process();
	}
	
	
	@Test
	public void setSourceAccountNumberTest(){
		int expected = 120;
		transaction.setSourceAccountNumber(expected);
		Assert.assertTrue(expected == transaction.getSourceAccountNumber());
	}
	
	@Test
	public void setDestinationAccountNumberTest(){
		int expected = 155;
		transaction.setDestinationAccountNumber(expected);
		Assert.assertTrue(expected == transaction.getDestinationAccountNumber());
	}
	
	@Test
	public void setAmountTest(){
		long expected = 10000;
		transaction.setAmount(expected);
		Assert.assertTrue(expected == transaction.getAmount());
	}
	
	@Test
	public void getSourceAccountNumberTest(){
		int expected = 40000;
		transaction.setSourceAccountNumber(expected);
		Assert.assertTrue(expected == transaction.getSourceAccountNumber());
	}
	
	@Test
	public void getDestinationAccountNumberTest(){
		int expected = 20000;
		transaction.setDestinationAccountNumber(expected);
		Assert.assertTrue(expected == transaction.getDestinationAccountNumber());
	}
	
	@Test
	public void getAmountTest(){
		int expected = 3000;
		transaction.setAmount(expected);
		Assert.assertTrue(expected == transaction.getAmount());
	}
	
	
	@Test
	public void compareTest1(){      // testing smaller than
		transaction  = new AtomicTransaction(1, 2, 5000);
		transaction2 = new AtomicTransaction(2, 1, 3000);
		Assert.assertTrue(transaction.compare(transaction, transaction2) == 1);
	} 
	
	@Test
	public void compareTest2(){      // testing equality
		transaction  = new AtomicTransaction(1, 2, 5000);
		transaction2 = new AtomicTransaction(2, 1, 5000);
		Assert.assertTrue(transaction.compare(transaction, transaction2) == 0);
	}
	
	@Test
	public void compareTest3(){      // testing greater than
		transaction  = new AtomicTransaction(1, 2, 2500);
		transaction2 = new AtomicTransaction(2, 1, 5555);
		Assert.assertTrue(transaction.compare(transaction, transaction2) == -1);
	} 

}
