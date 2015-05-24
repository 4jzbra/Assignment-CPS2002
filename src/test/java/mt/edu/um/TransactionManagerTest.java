package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionManagerTest {
	private TransactionManager transactionM;
	private AccountDatabase database;
	private AtomicTransaction atomicT1, atomicT2, atomicT3;
	private CompoundTransaction compoundT, compoundT2;

	
	@Before
	public void initialize() {
		transactionM = new TransactionManager();
		database = new AccountDatabase();
		atomicT1 = new AtomicTransaction(3, 4, 500);
		atomicT2 = new AtomicTransaction(4, 3, 750);
		atomicT3 = new AtomicTransaction(1, 4, 1555);
		compoundT = new CompoundTransaction("Main Transaction");
		compoundT2 = new CompoundTransaction("Sub Transaction");
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
	public void processTransactionTest4() {  //successful transaction
		final Account acc1 = new Account(3, "Savings", 5000);
		final Account acc2 = new Account(4, "Savings", 3500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
    	compoundT.addTransaction(atomicT1);
    	compoundT.addTransaction(atomicT2);
    	Assert.assertEquals(true, transactionM.processTransaction(compoundT));
	}
	
	@Test (expected = NullPointerException.class)   // when account does not exist
	public void processTransactionTest5() {      
		final Account acc1 = new Account(3, "Savings", 5000);
		final Account acc2 = new Account(4, "Savings", 3500);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
    	compoundT.addTransaction(atomicT3);
    	compoundT.addTransaction(atomicT2);
    	transactionM.processTransaction(compoundT);
	}
	
	@Test (expected = IllegalArgumentException.class) // compound transaction with no elements
	public void processTransactionTest6() {
		transactionM.processTransaction(compoundT);
	}
	
	@Test
	public void processTransactionTest7(){   // compound transaction with another compound transaction
		final Account acc1 = new Account(3, "Savings", 4000);
		final Account acc2 = new Account(4, "Savings", 2700);
		final Account acc3 = new Account(1, "Savings", 3330);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		compoundT2.addTransaction(atomicT3);
    	compoundT2.addTransaction(atomicT2);
    	compoundT.addTransaction(compoundT2);
    	compoundT.addTransaction(atomicT1);
    	Assert.assertEquals(true, transactionM.processTransaction(compoundT));
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
