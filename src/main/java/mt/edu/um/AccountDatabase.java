package mt.edu.um;

import java.util.ArrayList;

//Singleton Class
public class AccountDatabase{
	
	private static AccountDatabase instance = null;	
	ArrayList<Account> accountsArray = new ArrayList<Account>();
	
	public static AccountDatabase getInstance(){ //Lazy instantiation of the singleton object
		if(instance == null){
			instance = new AccountDatabase();
		}
		return instance;
	}
	
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
