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
    	Transaction t1 = new Transaction(1,2,300);
    	Transaction t2 = new Transaction(3,4,400);
    	Transaction t3 = new Transaction(1,5,900);
    	Transaction t4 = new Transaction(1,4,350);
    	
    	CompoundTransaction ct1 = new CompoundTransaction("Buy a Property");  // root transaction
    	CompoundTransaction ct2 = new CompoundTransaction("Prepare Bank Loan");
    	CompoundTransaction ct3 = new CompoundTransaction("Pay Fees");
    	
    	ct2.addTrans(t1);
    	ct2.addTrans(t2);
    	ct3.addTrans(t3);
    	ct3.addTrans(t4);
    	
    	ct1.addTrans2(ct2);
    	ct1.addTrans2(ct3);
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