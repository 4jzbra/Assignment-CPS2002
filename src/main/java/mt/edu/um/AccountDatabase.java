package mt.edu.um;

import java.util.ArrayList;

public class AccountDatabase{
	
	private static AccountDatabase instance = null;	
	ArrayList<Account> accountsArray = new ArrayList<Account>();
	
	public Account getAccount (int accountNumber){
		Account acc = new Account();
		return acc;
	}
	
	public int getSize(){
		return 0;
	}

}
