package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class TransactionManagerTest {
	private TransactionManager tm = new TransactionManager();
	
	@Test
	public void processTransactionTest() {	
		Assert.assertEquals(true, tm.processTransaction(1,2,5000));
	}
	
}
