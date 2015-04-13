package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	private Account acc;
	
	@Before
	public void initialize(){
		acc = new Account();
	}

	@Test
	public void adjustBalanceTest1(){
		final Account acc1 = new Account(1, "Savings", 15000);
		Assert.assertEquals(true, acc1.adjustBalance(-5000));  // new balance > 0 therefore true
	}
	
	@Test
	public void adjustBalanceTest2(){
		final Account acc1 = new Account(1, "Savings", 15000);
		Assert.assertEquals(false, acc1.adjustBalance(-25000)); // new balance < 0 therefore false
	}
	
	@Test
	public void adjustBalanceTest3(){
		final Account acc1 = new Account(1, "Savings", 15000);
		Assert.assertEquals(true, acc1.adjustBalance(-15000)); // new balance = 0 therefore true
	}
	
	@Test
	public void adjustBalanceTest4(){
		final Account acc1 = new Account(1, "Savings", 15000);
		acc1.adjustBalance(5000);
		Assert.assertEquals(20000, acc1.getAccountBalance());
	}
	
	@Test
	public void setAccountNumberTest(){
		int expected = 34;
		acc.setAccountNumber(expected);
		Assert.assertEquals(expected, acc.getAccountNumber());
	}
	
	@Test
	public void setAccountNameTest(){
		String expected = "Fixed";
		acc.setAccountName(expected);
		Assert.assertEquals(expected, acc.getAccountName());
	}
	
	@Test
	public void setAccountBalanceTest(){
		long expected = 25000;
		acc.setAccountBalance(expected);
		Assert.assertEquals(expected, acc.getAccountBalance());
	}
	
	@Test
	public void getAccountNumberTest(){
        int expected = 414;
        acc.setAccountNumber(expected);
        Assert.assertEquals(expected, acc.getAccountNumber());       
	}
	
	@Test
	public void getAccountNameTest(){
		String expected = "Savings";
		acc.setAccountName(expected);
		Assert.assertEquals(expected, acc.getAccountName());
	}
	
	@Test
	public void getAccountBalanceTest(){
		long expected = 10000;
		acc.setAccountBalance(expected);
		Assert.assertEquals(expected, acc.getAccountBalance());
	}

}
