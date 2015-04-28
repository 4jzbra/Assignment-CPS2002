package mt.edu.um;
import java.lang.UnsupportedOperationException;;

public abstract class Transaction {
	
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
	public boolean process(){
		throw new UnsupportedOperationException();
	}
	
	public boolean addTransaction(Transaction transaction){
		throw new UnsupportedOperationException();
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
