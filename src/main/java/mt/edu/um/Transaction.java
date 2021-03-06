package mt.edu.um;

public class Transaction {

	private int sourceAccountNumber; 
	private int destinationAccountNumber;
	private long amount;


	public Transaction() { 

	}

	public Transaction(int src, int dst, long amt) {
		setSourceAccountNumber(src);
		setDestinationAccountNumber(dst);
		setAmount(amt);
	}
	
	//method to check whether the transaction to be processed is valid or not
	public boolean process() {
		Account source = AccountDatabase.getAccount(sourceAccountNumber);
		Account destination = AccountDatabase.getAccount(destinationAccountNumber);
		
		if (source == null) { 
			return false;
		}
		if (destination == null){
			return false;
		}
		
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - amount) >= 0) {
			return true;
		} 
		else {
			return false;
		}
	}

	public void setSourceAccountNumber(int accNo) {
		sourceAccountNumber = accNo;
	}

	public void setDestinationAccountNumber(int accNo) {
		destinationAccountNumber = accNo;
	}

	public void setAmount(long amt) {
		amount = amt;
	}


	public int getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public int getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public long getAmount() {
		return amount;
	}

}
