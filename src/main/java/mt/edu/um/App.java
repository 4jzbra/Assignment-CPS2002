package mt.edu.um;

public class App 
{
	private static AccountDatabase database = new AccountDatabase();

    public static void main( String[] args )
    {
    	Account acc1 = new Account(1, "Fixed", 1000, 0);
		Account acc2 = new Account(2, "Savings", 2000, 0);
		Account acc3 = new Account(3, "Savings", 2500, 0);
		Account acc4 = new Account(4, "Fixed", 4000, 0);
		Account acc5 = new Account(2, "Fixed", 6700, 0);
		Account acc6 = new Account(4, "Fixed", 4900, 0);
		Account acc7 = new Account(5, "Visa", -500, 0);
		
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
    }
    
    public static void printAllAccounts() {
		for (int index = 0; index < database.accountsArray.size(); index++) {
			database.accountsArray.get(index).printAccountDetails();
		}
	}
}
