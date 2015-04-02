package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class AccountDatabaseTest {
	final AccountDatabase singleton = new AccountDatabase();
	
	@Test
	public void getAccountTest(){
		
	}
	
	@Test
	public void getSizeTest(){
		int actual = singleton.accountsArray.size();
		int expected = singleton.getSize();
		Assert.assertEquals(expected, actual);	
	}
	
	@Test
	public void singletonTest(){
		final AccountDatabase db1, db2;
		db1 = AccountDatabase.getInstance();
		db2 = AccountDatabase.getInstance();
		final Account acc1 = new Account(5, "Fixed", 12000);
		final Account acc2 = new Account(6, "Savings", 34000);
		db1.addNewAccount(acc1);
		db2.addNewAccount(acc2);
		
		Assert.assertEquals(true, db1 == db2);
	}
	@Test
	public void addNewAccountTest() {
		int sizeBefore = singleton.getSize();
		final Account newAcc = new Account(123, "Savings", 2000);
		singleton.addNewAccount(newAcc);
		int sizeAfter = singleton.getSize();
		Assert.assertEquals(sizeBefore + 1, sizeAfter);
	}

}
