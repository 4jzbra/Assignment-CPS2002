package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class TransactionManagerTest {
	private TransactionManager transactionM = new TransactionManager();
	private AccountDatabase database = new AccountDatabase();
	 

	public void addAccountsToDB(Account acc1, Account acc2){
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
	}
	
	@Test
	public void processTransactionTest1() {	
		final Account acc1 = new Account(1,"Savings",5000);
		final Account acc2 = new Account(2,"Savings",3500);
		addAccountsToDB(acc1, acc2);
		Assert.assertEquals(true, transactionM.processTransaction(1, 2, 3000));
	}
	
	@Test
	public void processTransactionTest2() {	
		final Account acc1 = new Account(3,"Savings",5000);
		final Account acc2 = new Account(4,"Savings",3500);
		addAccountsToDB(acc1, acc2);
		Assert.assertEquals(false, transactionM.processTransaction(1, 2, 6000));
	}
	
	@Test //transaction of same accounts twice i.e. 15secs have not elapsed
	public void processTransactionTest3() {	
		final Account acc1 = new Account(5,"Savings",5000);
		final Account acc2 = new Account(6,"Savings",3500);
		addAccountsToDB(acc1,acc2);
		transactionM.processTransaction(2, 1, 100); 
		Assert.assertEquals(false, transactionM.processTransaction(1, 2, 2000));
	}
	
	
	
}
