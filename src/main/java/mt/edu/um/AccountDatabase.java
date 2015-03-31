package mt.edu.um;

public class AccountDatabase extends Account {
	
	public AccountDatabase(){
		super();
	}
	
	public AccountDatabase(int accNo, String accName, long accBal){
		super(accNo, accName, accBal);
	}
	
	public Account getAccount (int accountNumber){
		Account acc = new Account();
		return acc;
	}
	
	public int getSize(){
		return 0;
	}

}
