package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;


public class AccountTest {
	final Account acc = new Account();

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
	public void setAccountNumberTest(){
		int expected = 34;
		acc.setAccountNumber(expected);
		int actual = acc.getAccountNumber();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setAccountNameTest(){
		String expected = "Fixed";
		acc.setAccountName(expected);
		String actual = acc.getAccountName();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setAccountBalanceTest(){
		long expected = 25000;
		acc.setAccountBalance(expected);
		long actual = acc.getAccountBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAccountNumberTest(){
        int expected = 414;
        acc.setAccountNumber(expected);
        int actual = acc.getAccountNumber();
        Assert.assertEquals(expected, actual);       
	}
	
	@Test
	public void getAccountNameTest(){
		String expected = "Savings";
		acc.setAccountName(expected);
		String actual = acc.getAccountName();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAccountBalanceTest(){
		long expected = 10000;
		acc.setAccountBalance(expected);
		long actual = acc.getAccountBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void printAccountDetailsTest(){    // (provisional test)
		int expected1 = 414;
		String expected2 = "Savings";
		long expected3 = 10000;
		acc.setAccountNumber(expected1);
		acc.setAccountName(expected2);
		acc.setAccountBalance(expected3);
		int actual1 = acc.getAccountNumber();
		String actual2 = acc.getAccountName();
		long actual3 = acc.getAccountBalance();
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}
	
	
	

}
