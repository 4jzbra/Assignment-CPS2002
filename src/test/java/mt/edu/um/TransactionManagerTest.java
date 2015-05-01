package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionManagerTest {
	private TransactionManager transactionM;
	private AccountDatabase database;
	private CompoundTransaction compoundT;

	
	@Before
	public void initialize() {
		transactionM = new TransactionManager();
		database = new AccountDatabase();
		compoundT = new CompoundTransaction("Main Transaction");
	}

	// Tests for Atomic processTransaction
	@Test
	public void processTransactionTest1() {             
		final Account acc1 = new Account(1, "Savings", 5000);
		final Account acc2 = new Account(2, "Savings", 3500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		Assert.assertEquals(true, transactionM.processTransaction(1, 2, 3000));
	}

	@Test (expected = IllegalArgumentException.class)  // insufficient balance 
	public void processTransactionTest2() {
		final Account acc1 = new Account(3, "Savings", 5000);
		final Account acc2 = new Account(4, "Savings", 3500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		transactionM.processTransaction(3, 4, 6000);
	}

	@Test (expected = NullPointerException.class) // accounts do not exist test 
	public void processTransactionTest3() {
		transactionM.processTransaction(15, 16, 2000);
	}
	
	//Tests for Compound processTransaction
	@Test
	public void processTransactionTest4() {
		final Account acc1 = new Account(3, "Savings", 5000);
		final Account acc2 = new Account(4, "Savings", 3500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		Transaction t1 = new AtomicTransaction(3,4,300);
    	Transaction t2 = new AtomicTransaction(4,3,400);
    	compoundT.addTransaction(t1);
    	compoundT.addTransaction(t2);
    	Assert.assertEquals(true, transactionM.processTransaction(compoundT));
	}
	
	@Test (expected = IllegalArgumentException.class) // compound transaction with no elements
	public void processTransactionTest5() {
		transactionM.processTransaction(compoundT);
	}
	
	
	
	@Test  //testing constructor for AtomicTransaction
	public void constructorTest1() {
		final Account acc1 = new Account(7, "Savings", 4000);
		final Account acc2 = new Account(8, "Savings", 2600);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);

		int num = transactionM.getNumTransactionsProcessed();
		TransactionManager tm = new TransactionManager(7, 8, 1100);
		Assert.assertEquals(num + 1, tm.getNumTransactionsProcessed());
	}
	
	@Test  //testing constructor for CompoundTransaction
	public void constructorTest2() {
		final Account acc1 = new Account(7, "Savings", 4000);
		final Account acc2 = new Account(8, "Savings", 2600);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		
		Transaction t1 = new AtomicTransaction(7, 8, 1100);
		CompoundTransaction compTrans = new CompoundTransaction();
		compTrans.addTransaction(t1);
		
		int num = transactionM.getNumTransactionsProcessed();
		TransactionManager tm = new TransactionManager(compTrans);
		Assert.assertEquals(num + 1, tm.getNumTransactionsProcessed());
	}
	
	
}
