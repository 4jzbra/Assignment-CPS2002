package iterator;

import mt.edu.um.Account;
import mt.edu.um.AccountDatabase;
import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;
import mt.edu.um.Transaction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CriteriaIncAmountsTest {
    
    private CompoundTransaction compoundT;
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
    }
    
 
    @Test
    public void MeetCriteriaTest() {    
        CriteriaIncAmounts cia = new CriteriaIncAmounts();
        assertEquals(true, cia.meetCriteria(compoundT));
    }
    
}
