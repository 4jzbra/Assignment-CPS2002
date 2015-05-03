package mt.edu.um;

import java.util.ArrayList;

public class App 
{
	private static AccountDatabase database = new AccountDatabase();

    public static void main( String[] args )
    {
    	testingHighRisk(); //not working properly
    	  	
    	//testing();
    	
    }
    
    public static void testingHighRisk(){
    	createAccounts(); //creates accounts from 1 to 7
    	/* Accounts needed for high and low risk */
    	Account a = new Account(3123, "High risk deposit source acc", 20000);
    	Account b = new Account(8665, "Low risk deposit source acc", 20000);
    	Account c = new Account(3143, "High risk main transaction source acc", 20000);
    	Account d = new Account(3133, "Low risk main transaction source acc", 20000);
    	Account e = new Account(6565, "High risk commission source acc", 20000);
    	Account f = new Account(4444, "High risk commission destination acc", 20000);
    	Account g = new Account(6588, "Low risk commission source acc", 20000);
    	Account h = new Account(4445, "Low risk commission destination acc", 20000);
    	
    	database.addNewAccount(a);
    	database.addNewAccount(b);
    	database.addNewAccount(c);
    	database.addNewAccount(d);
    	database.addNewAccount(e);
    	database.addNewAccount(f);
    	database.addNewAccount(g);
    	database.addNewAccount(h);
    	
    	/* ************************************* */
    	
    	int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400};
    	
    	Director director = new Director();
    	CompoundTransaction highRiskTrans = director.createTransaction("high",6,400, dstAccounts, amounts);
    	
    	System.out.println(a.getAccountNumber()+" bal: "+a.getAccountBalance());
    	System.out.println(c.getAccountNumber()+" bal: "+c.getAccountBalance()); 
    	System.out.println(e.getAccountNumber()+" bal: "+e.getAccountBalance());
    	System.out.println(f.getAccountNumber()+" bal: "+f.getAccountBalance());    	
    	TransactionManager tm = new TransactionManager();
    	tm.processTransaction(highRiskTrans);
    	System.out.println(a.getAccountNumber()+" bal: "+a.getAccountBalance());
    	System.out.println(c.getAccountNumber()+" bal: "+c.getAccountBalance()); 
    	System.out.println(e.getAccountNumber()+" bal: "+e.getAccountBalance());
    	System.out.println(f.getAccountNumber()+" bal: "+f.getAccountBalance());
    	
    	//printAllAccounts();
    }
    
    public static void testing(){
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
    	
    	CompoundTransaction ct1 = new CompoundTransaction("MAIN");  // root transaction
    	CompoundTransaction ct2 = new CompoundTransaction("SUB1");
    	CompoundTransaction ct3 = new CompoundTransaction("SUB2");
    	
        ct2.addTransaction(t1);
    	ct2.addTransaction(t2);
    	ct3.addTransaction(t3);
    	ct3.addTransaction(t4);
    	
    	ct1.addTransaction(ct2);
    	ct1.addTransaction(ct3);
    	
    	//testing the factory & compound 
    	/*
    	TransactionFactory tr = new TransactionFactory();
    	
    	CompoundTransaction compTrans1 = null;
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
    	*/
    	
    	System.out.println(acc1.getAccountNumber()+" bal: "+acc1.getAccountBalance());
    	System.out.println(acc2.getAccountNumber()+" bal: "+acc2.getAccountBalance()); 
    	System.out.println(acc3.getAccountNumber()+" bal: "+acc3.getAccountBalance());
    	System.out.println(acc4.getAccountNumber()+" bal: "+acc4.getAccountBalance());
    	TransactionManager tm = new TransactionManager(ct1);
    	tm.processTransaction(3, 1, 45);
    	System.out.println(acc1.getAccountNumber()+" bal: "+acc1.getAccountBalance()); 
    	System.out.println(acc2.getAccountNumber()+" bal: "+acc2.getAccountBalance()); 
    	System.out.println(acc3.getAccountNumber()+" bal: "+acc3.getAccountBalance()); 
    	System.out.println(acc4.getAccountNumber()+" bal: "+acc4.getAccountBalance()); 
    	
    	System.out.println(tm.getNumTransactionsProcessed()); 
    }
    
    public static void createAccounts(){
    	Account acc1 = new Account(1, "Fixed", 10000);
		Account acc2 = new Account(2, "Savings", 2000);
		Account acc3 = new Account(3, "Savings", 2500);
		Account acc4 = new Account(4, "Fixed", 4000);
		Account acc7 = new Account(5, "Visa", -500);
		Account acc8 = new Account(6, "Fixed", 400);
		
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		database.addNewAccount(acc4);
		database.addNewAccount(acc7);
		database.addNewAccount(acc8);
    }
    
    public static void printAllAccounts() {
    	Account acc;
		for (int index = 0; index < AccountDatabase.accountsArray.size(); index++) {
			acc = AccountDatabase.accountsArray.get(index);
			System.out.println("Account Number: " + acc.getAccountNumber() + "\tName: "
					+ acc.getAccountName() + "\tBalance: " + acc.getAccountBalance());
		}
	}
}