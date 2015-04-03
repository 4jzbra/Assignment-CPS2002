package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class AccountDatabaseTest {
	final AccountDatabase database = new AccountDatabase();
	
	@Test
	public void getAccountTest(){
		Account acc = new Account(4, "Fixed", 1000);
		database.accountsArray.add(acc);
		Assert.assertEquals(acc, database.accountsArray.get(0));
	}
	
	@Test
	public void getSizeTest(){
		int actual = database.accountsArray.size();
		int expected = database.getSize();
		Assert.assertEquals(expected, actual);	
	}


}
