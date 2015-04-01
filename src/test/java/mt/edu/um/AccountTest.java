package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;


public class AccountTest {
final Account acc = new Account();
	
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
	public void getAccountName(){
		String expected = "Savings";
		acc.setAccountName(expected);
		String actual = acc.getAccountName();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAccountBalance(){
		long expected = 10000;
		acc.setAccountBalance(expected);
		long actual = acc.getAccountBalance();
		Assert.assertEquals(expected, actual);
	}
	
	
	

}
