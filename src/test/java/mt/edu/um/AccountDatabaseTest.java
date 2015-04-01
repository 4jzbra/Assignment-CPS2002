package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class AccountDatabaseTest {
	
	private static AccountDatabase singleton = new AccountDatabase();
	
	@Test
	public void getAccountTest(){
		
	}
	
	@Test
	public void getSizeTest(){
		int actual = singleton.accountsArray.size();
		int expected = singleton.getSize();
		Assert.assertEquals(expected, actual);	
	}

}
