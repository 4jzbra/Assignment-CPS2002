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
	
	@Test
	public void addNewAccountTest1() {
		final Account acc = new Account(1, "Savings", 2000);
		Assert.assertEquals(true, database.addNewAccount(acc));
	}
	
	@Test
	public void addNewAccountTest2(){
		Account acc1 = new Account(1, "Fixed", 5600);
		Account acc2 = new Account(1, "Savings", 89000);
		database.addNewAccount(acc1);
		Assert.assertEquals(false, database.addNewAccount(acc2));
	}
	
	public void alreadyExistsTest(){
		Account newAcc = new Account(1, "Fixed", 5600);
		database.accountsArray.add(newAcc);
		Assert.assertEquals(true, database.alreadyExists(1));	
	}


}
