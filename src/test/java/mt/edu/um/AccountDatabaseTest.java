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
	public void addNewAccountTest1() {
		final Account acc = new Account(1, "Savings", 2000);
		Assert.assertEquals(true, singleton.addNewAccount(acc));
	}
	
	@Test
	public void addNewAccountTest2(){
		Account acc1 = new Account(1, "Fixed", 5600);
		Account acc2 = new Account(1, "Savings", 89000);
		singleton.addNewAccount(acc1);
		Assert.assertEquals(false, singleton.addNewAccount(acc2));
	}
	
	public void alreadyExistsTest(){
		Account newAcc = new Account(1, "Fixed", 5600);
		singleton.accountsArray.add(newAcc);
		Assert.assertEquals(true, singleton.alreadyExists(1));	
	}

}
