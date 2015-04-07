package mt.edu.um;

public class Account {
	
	private int accountNumber;   // unique account number
	private String accountName;  // eg fixed account, savings, etc...
	private long accountBalance; // current amount in the account
	
	public Account(){      //default constructor

	}
	
	public Account(int accNo, String accName, long accBal){
		setAccountNumber(accNo);
		setAccountName(accName);
		setAccountBalance(accBal);
	}
	
	public boolean adjustBalance(long amount){   // checks if balance is correct
		//checking if balance is not smaller than 0 after adding amount
		if((this.accountBalance + amount) >= 0){ 
			this.accountBalance += amount;
			return true;
		}
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
	
	public void printAccountDetails() {
		System.out.println("Account Number: " + accountNumber + "\tName: "
				+ accountName + "\tBalance: " + accountBalance);
	}
	
	
	

}
