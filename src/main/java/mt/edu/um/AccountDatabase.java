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
	
	//method to add new account to the ArrayList
	public boolean addNewAccount(Account acc){
		if (this.alreadyExists(acc.getAccountNumber()) == true) {
			System.out.println("Error: Account number "+acc.getAccountNumber()+" already exists!");
			return false;
		} else {
			this.accountsArray.add(acc);
			return true;
		}
	}
	
	public boolean alreadyExists(int accNo){
		for(int i = 0; i < this.getSize(); i++){
			if(accNo == accountsArray.get(i).getAccountNumber()){
				return true;
			}
		}
		return false;
	}

}
