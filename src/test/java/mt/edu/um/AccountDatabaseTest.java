package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class AccountDatabaseTest {
	final AccountDatabase database = new AccountDatabase();
	
	@Test
	public void getAccountTest(){
		
	}
	
	@Test
	public void getSizeTest(){
		int actual = database.accountsArray.size();
		int expected = database.getSize();
		Assert.assertEquals(expected, actual);	
	}


}
