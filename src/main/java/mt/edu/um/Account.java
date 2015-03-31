package mt.edu.um;

public class Account {
	
	private int accountNumber;   // unique account number
	private String accountName;  // eg fixed account, savings, etc...
	private long accountBalance; // current amount in the account
	
	public Account(){      //default constructor
		accountNumber = 0;
		accountName = null;
		accountBalance = 0;
	}
	
	public Account(int accNo, String accName, long accBal){
		setAccountNumber(accNo);
		accountName = accName;
		accountBalance = accBal;
	}
	
	public boolean adjustBalance(long amount){   // checks if balance is correct
		return false;
	}
	
	public void setAccountNumber(int accNo){
		accountNumber = accNo;
	}
	
	public void setAccountName(String accName){
		accountName = accName;
	}
	
	public void setAccountBalance(long accBal){
		accountBalance = accBal;
	}
	
	int getAccountNumber(){
		return accountNumber;
	}
	
	String getAccountName(){
		return accountName;
	}
	
	long getAccountBalance(){
		return accountBalance;
	}

}
