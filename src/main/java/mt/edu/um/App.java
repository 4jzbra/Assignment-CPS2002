package mt.edu.um;

public class App 
{
	private static AccountDatabase database = new AccountDatabase();

    public static void main( String[] args )
    {
    	Account acc1 = new Account(1, "Fixed", 1000);
		Account acc2 = new Account(2, "Savings", 2000);
		Account acc3= new Account(3, "Savings", 2500);
		Account acc4 = new Account(4, "Fixed", 4000);
		Account acc5 = new Account(2, "Fixed", 6700);
		Account acc6 = new Account(4, "Fixed", 4900);
		
		database.addNewAccount(acc1);
		database.addNewAccount(acc2);
		database.addNewAccount(acc3);
		database.addNewAccount(acc4);
		database.addNewAccount(acc5);
		database.addNewAccount(acc6);
		System.out.println(database.getSize());
		printAllAccounts();
    }
    
    public static void printAllAccounts() {
		for (int index = 0; index < database.accountsArray.size(); index++) {
			database.accountsArray.get(index).printAccountDetails();
		}
	}
}
