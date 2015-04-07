package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class TransactionManagerTest {
	private TransactionManager transactionM = new TransactionManager();
	private AccountDatabase database = new AccountDatabase();
	final private Account acc1 = new Account(1,"Savings",5000);
	final private Account acc2 = new Account(2,"Savings",3500); 

	
	@Test
	public void processTransactionTest1() {	
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
	
		Assert.assertEquals(true, transactionM.processTransaction(1, 2, 3000));
	}
	
}
