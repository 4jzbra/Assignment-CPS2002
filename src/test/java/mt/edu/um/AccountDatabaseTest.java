package mt.edu.um;

import org.junit.Assert;
import org.junit.Test;

public class AccountDatabaseTest {
	
	final AccountDatabase database = new AccountDatabase();
	
	@Test
	public void initialEmptyDatabase(){
		Assert.assertEquals(true, AccountDatabase.accountsArray.isEmpty());
	}
	
	@Test
	public void getAccountTest1(){
		Account acc = new Account(1, "Fixed", 1000);
		database.addNewAccount(acc);
		Assert.assertEquals(acc, AccountDatabase.accountsArray.get(database.getSize()-1));
	}
	
	@Test
	public void getAccountTest2(){
		Account acc = new Account(2, "Savings", 4000);
		database.addNewAccount(acc);
		Assert.assertEquals(acc, AccountDatabase.getAccount(2));
	}
	
	@Test
	public void getSizeTest1(){
		int expected = AccountDatabase.accountsArray.size();
		Assert.assertEquals(expected, database.getSize());	
	}
	
	@Test
	public void getSizeTest2(){
		Account acc = new Account(3, "Savings", 3000);
		database.addNewAccount(acc);
		int expected = AccountDatabase.accountsArray.size();
		Assert.assertEquals(expected, database.getSize());	
	}
	
	@Test  // when account is unique
	public void addNewAccountTest1() {
		final Account acc = new Account(9, "Savings", 2000);
		Assert.assertEquals(true, database.addNewAccount(acc));
	}
	
	@Test  // when account already exists
	public void addNewAccountTest2(){
		AccountDatabase.accountsArray.clear();
		Account acc1 = new Account(1, "Fixed", 5600);
		Account acc2 = new Account(1, "Savings", 89000);
		database.addNewAccount(acc1);
		Assert.assertEquals(false, database.addNewAccount(acc2));
	}
	
	@Test  // checking if account already exists
	public void alreadyExistsTest1(){
		AccountDatabase.accountsArray.clear();
		Account newAcc = new Account(1, "Fixed", 5600);
		AccountDatabase.accountsArray.add(newAcc);
		Assert.assertEquals(true, database.alreadyExists(1));	
	}
	
	@Test  // when account does not exist
	public void alreadyExistsTest2(){
		Account newAcc = new Account(6, "Fixed", 5600);
		AccountDatabase.accountsArray.add(newAcc);
		Assert.assertEquals(false, database.alreadyExists(5));	
	}  


}
