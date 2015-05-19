package iterator;

import mt.edu.um.Account;
import mt.edu.um.AccountDatabase;
import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;
import mt.edu.um.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class CompoundTransactionIteratorTest {
    
    private CompoundTransaction compoundT, compoundT2;
    private AccountDatabase database;
    private Account acc1, acc2, acc3;
    private Transaction t1, t2, t3;
    
    @Before
    public void init() {
        database = new AccountDatabase();
        acc1 = new Account(1, "Bank Loan", 10000);
        acc2 = new Account(2, "Payee Current Account", 4500);
        acc3 = new Account(3, "Seller Current Account", 10000);
        database.addNewAccount(acc1);
        database.addNewAccount(acc2);
        database.addNewAccount(acc3);
        compoundT = new CompoundTransaction();
        t1 = new AtomicTransaction(1, 2, 3000);
        t2 = new AtomicTransaction(3, 2, 5000);
        t3 = new AtomicTransaction(2, 3, 2555);
        compoundT.addTransaction(t1);
        compoundT.addTransaction(t2);
        compoundT.addTransaction(t3);
        compoundT2 = new CompoundTransaction();
    }


    @Test
    public void HasNextTest1() {
        CompoundTransactionIterator cti = new CompoundTransactionIterator(compoundT.getElements());
        Assert.assertEquals(true, cti.hasNext()); 
    }
    
    @Test
    public void HasNextTest2() {     // empty compound transaction
        CompoundTransactionIterator cti = new CompoundTransactionIterator(compoundT2.getElements());
        Assert.assertEquals(false, cti.hasNext()); 
    }
    
    @Test
    public void HasNext3(){
    	compoundT2.addTransaction(t1);
    	compoundT.addTransaction(compoundT2);
    	CompoundTransactionIterator cti = new CompoundTransactionIterator(compoundT.getElements());
        Assert.assertEquals(true, cti.hasNext()); 
    }

    @Test
    public void NextTest() {         // next transaction (in this case t1)
        CompoundTransactionIterator cti = new CompoundTransactionIterator(compoundT.getElements());
        Assert.assertEquals(t1, cti.next());
        
    } 
    
}