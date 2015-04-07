package mt.edu.um;

import java.util.ArrayList;


public class AccountDatabase{
	
	static ArrayList<Account> accountsArray = new ArrayList<Account>();
	
	public AccountDatabase(){
		accountsArray.clear();
	}
	
	//method to search for an account
	public static Account getAccount(int accountNumber){
		for(int i = 0; i < accountsArray.size(); ++i){
			if (accountNumber == accountsArray.get(i).getAccountNumber()){
				return accountsArray.get(i);
			}
		}
		return null;
	}
	
	//method that returns the size of the database
	public int getSize(){
		return accountsArray.size();
	}
	
	//method to add new account to the ArrayList
	public boolean addNewAccount(Account acc){
		if (alreadyExists(acc.getAccountNumber()) == true) {
			System.out.println("Error: Account number " + acc.getAccountNumber() + " already exists!");
			return false;
		} 
		else {
			accountsArray.add(acc);
			return true;
		}
	}
	
	//method to ensure that account number is unique
	public boolean alreadyExists(int accNo){
		for(int i = 0; i < this.getSize(); ++i){
			if(accNo == accountsArray.get(i).getAccountNumber()){
				return true;
			}
		}
		return false;
	}

}
