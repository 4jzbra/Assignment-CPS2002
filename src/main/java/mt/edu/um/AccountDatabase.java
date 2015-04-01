package mt.edu.um;

import java.util.ArrayList;

public class AccountDatabase{
	
	private static AccountDatabase instance = null;	
	ArrayList<Account> accountsArray = new ArrayList<Account>();
	
	public Account getAccount(int accountNumber){
		for(int i = 0; i < this.accountsArray.size(); i++){
			if (accountNumber == this.accountsArray.get(i).getAccountNumber()){
				return this.accountsArray.get(i);
			}
		}
		return null;
	}
	
	public int getSize(){
		return this.accountsArray.size();
	}

}
