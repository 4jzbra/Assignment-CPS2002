package mt.edu.um;

public class App 
{
	private static AccountDatabase database = new AccountDatabase();

    public static void main( String[] args )
    {
    	
    	Account acc1 = new Account(1, "Fixed", 10000);
		Account acc2 = new Account(2, "Savings", 2000);
		Account acc3 = new Account(3, "Savings", 2500);
		Account acc4 = new Account(4, "Fixed", 4000);
		Account acc5 = new Account(2, "Fixed", 6700);
		Account acc6 = new Account(4, "Fixed", 4900);
		Account acc7 = new Account(5, "Visa", -500);
		
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		database.addNewAccount(acc4);
		database.addNewAccount(acc5);
		database.addNewAccount(acc6);
		database.addNewAccount(acc7);
		
		acc7.adjustBalance(500);  // settles account to 0
		
		System.out.println("Accounts in database: " + database.getSize());
		
		printAllAccounts();
		System.out.println("\n");  /*
		TransactionManager transaction = new TransactionManager(1,2,400);
		TransactionManager transaction2 = new TransactionManager(3,4,400);
		System.out.println(transaction2.getNumTransactionsProcessed());
		printAllAccounts();
	/*	
		try {
		    Thread.sleep(16000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}   
		
		TransactionManager transaction3 = new TransactionManager(1,5,4000); //ok
		System.out.println(transaction3.getNumTransactionsProcessed());
		printAllAccounts();
		TransactionManager transaction4 = new TransactionManager(4,3,8000); //insufficient
		System.out.println(transaction.getNumTransactionsProcessed());
		printAllAccounts();
     
    */
    	
    	// Testing Compound Transactions (change 1)  [ignoring tm]
    	Transaction t1 = new AtomicTransaction(1,2,300);
    	Transaction t2 = new AtomicTransaction(1,4,400);
    	Transaction t3 = new AtomicTransaction(1,5,900);
    	Transaction t4 = new AtomicTransaction(1,4,350);
    	
    	Transaction ct1 = new CompoundTransaction("MAIN");  // root transaction
    	Transaction ct2 = new CompoundTransaction("SUB1");
    	Transaction ct3 = new CompoundTransaction("SUB2");
    	
        ct2.addTransaction(t1);
    	ct2.addTransaction(t2);
    	ct3.addTransaction(t3);
    	ct3.addTransaction(t4);
    	
    	ct1.addTransaction(ct2);
    	ct1.addTransaction(ct3); 
    	
    	//testing the factory & compound
    	TransactionFactory tr = new TransactionFactory();
    	
    	Transaction compTrans1 = null;
    	compTrans1 = tr.getTransaction("Compound");
    	if(compTrans1.addTransaction(t1)) System.out.println("t1 Added successfully");
    	if(compTrans1.addTransaction(t2)) System.out.println("t2 Added successfully");
    	
    	Transaction compTrans2 = null;
    	compTrans2 = tr.getTransaction("Compound");
    	if(compTrans2.addTransaction(t3)) System.out.println("t3 Added successfully");
    	if(compTrans2.addTransaction(t4)) System.out.println("t4 Added successfully");
    	
    	Transaction compTrans3 = null;
    	compTrans3 = tr.getTransaction("Compound");
    	if(compTrans3.addTransaction(compTrans1)) System.out.println("compTrans1 Added successfully");
    	if(compTrans3.addTransaction(compTrans2)) System.out.println("compTrans2 Added successfully");
    	
    	
    	System.out.println(acc1.getAccountNumber()+" bal: "+acc1.getAccountBalance());
    	System.out.println(acc2.getAccountNumber()+" bal: "+acc2.getAccountBalance()); 
    	System.out.println(acc3.getAccountNumber()+" bal: "+acc3.getAccountBalance());
    	System.out.println(acc4.getAccountNumber()+" bal: "+acc4.getAccountBalance());
    	TransactionManager tm = new TransactionManager(compTrans3);
    	System.out.println(acc1.getAccountNumber()+" bal: "+acc1.getAccountBalance()); 
    	System.out.println(acc2.getAccountNumber()+" bal: "+acc2.getAccountBalance()); 
    	System.out.println(acc3.getAccountNumber()+" bal: "+acc3.getAccountBalance()); 
    	System.out.println(acc4.getAccountNumber()+" bal: "+acc4.getAccountBalance()); 
    	
    	System.out.println(tm.getNumTransactionsProcessed());
    	
    }
    
    
    
    
    public static void printAllAccounts() {
    	Account acc = new Account();
		for (int index = 0; index < database.accountsArray.size(); index++) {
			acc = database.accountsArray.get(index);
			System.out.println("Account Number: " + acc.getAccountNumber() + "\tName: "
					+ acc.getAccountName() + "\tBalance: " + acc.getAccountBalance());
		}
	}
}