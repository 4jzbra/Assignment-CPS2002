package mt.edu.um;
import java.util.ArrayList;


public class AccountDatabase{	
	ArrayList<Account> accountsArray = new ArrayList<Account>();
	
	public AccountDatabase(){
		
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
