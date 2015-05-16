package mt.edu.um;

import iterator.TraverseTransactions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TraverseTransactionsTest {
	
	private TraverseTransactions travTrans;
	private CompoundTransaction compTrans;
	private AccountDatabase database;
	private Account acc1, acc2, acc3;
	
	
	@Before
	public void init(){
		//travTrans = new TraverseTransactions();
		database = new AccountDatabase();
		compTrans = new CompoundTransaction();
		acc1 = new Account(1, "Bank Loan", 10000);
		acc2 = new Account(2, "Payee Current Account", 4500);
		acc3 = new Account(3, "Seller Current Account", 10000);
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
	}
	
	
	@Test
	public void printTransactionTest(){
		Transaction t1 = new AtomicTransaction(2, 3, 2000); 
		Transaction t2 = new AtomicTransaction(1, 2, 900); 
		compTrans.addTransaction(t1);
		compTrans.addTransaction(t2);
		//Iterator<Transaction> iter = compTrans.createIterator();
		travTrans = new TraverseTransactions(compTrans);
		Assert.assertEquals(true, travTrans.printTransactions());
	}
	
	@Test
	public void printAscendingOrder(){
		Transaction t1 = new AtomicTransaction(2, 3, 2000); 
		Transaction t2 = new AtomicTransaction(1, 2, 900);
		Transaction t3 = new AtomicTransaction(1, 3, 2000); 
		Transaction t4 = new AtomicTransaction(2, 1, 700);
		compTrans.addTransaction(t1);
		compTrans.addTransaction(t2);
		compTrans.addTransaction(t3);
		compTrans.addTransaction(t4);
		travTrans = new TraverseTransactions(compTrans);
		Assert.assertEquals(true, travTrans.printTransactions());
	}
	
	@Test
	public void printDescendingOrder(){
		Transaction t1 = new AtomicTransaction(2, 3, 2000); 
		Transaction t2 = new AtomicTransaction(1, 2, 900);
		Transaction t3 = new AtomicTransaction(1, 3, 2000); 
		Transaction t4 = new AtomicTransaction(2, 1, 700);
		compTrans.addTransaction(t1);
		compTrans.addTransaction(t2);
		compTrans.addTransaction(t3);
		compTrans.addTransaction(t4);
		travTrans = new TraverseTransactions(compTrans);
		Assert.assertEquals(true, travTrans.printTransactions());
	}
	

}
