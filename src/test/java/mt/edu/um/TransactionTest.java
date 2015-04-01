package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
	private Transaction instance;
	
	@Test
	public void processTest() {
		instance = new Transaction();
		boolean actual = instance.process();
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void setSourceAccountNumberTest(){
		instance = new Transaction();
		int expected = 120;
		instance.setSourceAccountNumber(expected);
		int actual = instance.getSourceAccountNumber();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setDestinationAccountNumberTest(){
		instance = new Transaction();
		int expected = 155;
		instance.setDestinationAccountNumber(expected);
		int actual = instance.getDestinationAccountNumber();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setAmountTest(){
		instance = new Transaction();
		long expected = 10000;
		instance.setAmount(expected);
		long actual = instance.getAmount();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getSourceAccountNumberTest(){
		instance = new Transaction();
		int expected = 40000;
		instance.setSourceAccountNumber(expected);
		Assert.assertTrue(instance.getSourceAccountNumber() == expected);
	}
	
	@Test
	public void getDestinationAccountNumberTest(){
		instance = new Transaction();
		int expected = 20000;
		instance.setDestinationAccountNumber(expected);
		Assert.assertTrue(instance.getDestinationAccountNumber() == expected);
	}
	
	@Test
	public void getAmountTest(){
		instance = new Transaction();
		int expected = 3000;
		instance.setAmount(expected);
		Assert.assertTrue(instance.getAmount() == expected);
	}
	

}
