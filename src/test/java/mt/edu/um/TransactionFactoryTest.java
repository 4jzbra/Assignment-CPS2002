package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionFactoryTest {
	
	TransactionFactory factory;
	Transaction transaction;
	
	@Before
	public void initialize(){
		factory = new TransactionFactory();
	}
	
	@Test
	public void getTransactionTes1t(){
		transaction = factory.getTransaction("Compound");
		Assert.assertEquals(true, transaction instanceof CompoundTransaction);
	}
	
	@Test
	public void getTransactionTest2(){
		transaction = factory.getTransaction("Atomic");
		Assert.assertEquals(true, transaction instanceof AtomicTransaction);
	}
	
	@Test
	public void getTransactionTest3(){
		Assert.assertEquals(null, factory.getTransaction("abc"));
	}
	
	
}
