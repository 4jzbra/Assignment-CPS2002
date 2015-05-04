package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DirectorTest {
	
	@Before
	public void init(){
		//creation of accounts
    	Account acc1 = new Account(1, "Fixed", 3000);
		Account acc2 = new Account(2, "Savings", 2000);
		Account acc3 = new Account(3, "Savings", 2500);
		Account acc4 = new Account(4, "Fixed", 4000);
		Account acc5 = new Account(5, "Visa", -500);
		Account acc6 = new Account(6, "Fixed", 400);
		//adding accounts to the database
		AccountDatabase database = new AccountDatabase();
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		database.addNewAccount(acc4);
		database.addNewAccount(acc5);
		database.addNewAccount(acc6);
	}
	
	//testing a high risk creation
	@Test
	public void createTransactionTest1(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400}; 
    	//not ready
    	Director director = new Director();
    	CompoundTransaction highRiskTrans = director.createTransaction("high",6, 400, dstAccounts, amounts);
    	Assert.assertEquals(3, highRiskTrans.getElements().size());
	}
	
	//testing a low risk creation
	@Test
	public void createTransactionTest2(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400}; 
    	//not ready
    	Director director = new Director();
    	CompoundTransaction lowRiskTrans = director.createTransaction("low",6, 400, dstAccounts, amounts);
    	Assert.assertEquals(3, lowRiskTrans.getElements().size());
	}
	
}
