package mt.edu.um;

import iterator.CompoundTransactionIterator;
import iterator.TransactionIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompoundTransactionTest {
	private CompoundTransaction transaction, transaction2;
	private AccountDatabase database;
	private Account acc1, acc2, acc3;
	private TransactionManager tm;
	
	@Before
	public void initialize(){
		database = new AccountDatabase();
		acc1 = new Account(1, "Bank Loan", 10000);
		acc2 = new Account(2, "Payee Current Account", 4500);
		acc3 = new Account(3, "Seller Current Account", 10000);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		transaction = new CompoundTransaction("Prepare Bank Loan");
		transaction2 = new CompoundTransaction();

	}
	
	@Test 
	public void processTest1() {
		transaction.addTransaction(new AtomicTransaction(1, 2, 5000));
		transaction.addTransaction(new AtomicTransaction(2, 3, 8000));
		tm = new TransactionManager();
		Assert.assertEquals(true, tm.processTransaction(transaction));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void processTest2() {
		tm = new TransactionManager();
		tm.processTransaction(transaction);
	}
	
	@Test
	public void addTransactionTest1(){
		transaction.addTransaction(new AtomicTransaction(1, 2, 100));
		Assert.assertEquals(1, transaction.getElements().size());
	}
	
	@Test
	public void addTransactionTest2(){      // duplicate transaction
		transaction.addTransaction(transaction2);
		Assert.assertEquals(false, transaction.addTransaction(transaction2));
	}
	
	
	@Test
	public void setNameTest(){
		transaction.setName("Pay Loan");
		Assert.assertEquals("Pay Loan", transaction.getName());
	}
	
	@Test
	public void getNameTest(){
		transaction.setName("Pay Deposit");
		Assert.assertEquals("Pay Deposit", transaction.getName());
	}
}
