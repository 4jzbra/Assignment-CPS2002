package mt.edu.um;

public class Transaction {

	private int sourceAccountNumber;       // source of transaction
	private int destinationAccountNumber;  // destination of transaction
	private long amount;                  
	
	public Transaction(){       // default constructor
		
	}

	public Transaction(int src, int dst, long amt){
		setSourceAccountNumber(src);
		setDestinationAccountNumber(dst);
		setAmount(amt);
	}
	
	public boolean process() {
		return true;
	}

	public void setSourceAccountNumber(int accNo) {
		sourceAccountNumber = accNo;
	}
	
	public void setDestinationAccountNumber(int accNo) {
		destinationAccountNumber = accNo;
	}
	
	public void setAmount(long amt){
		amount = amt;
	}
	
	public int getSourceAccountNumber(){
		return sourceAccountNumber;
	}
	
	public int getDestinationAccountNumber(){
		return destinationAccountNumber;
	}
	
	public long getAmount(){
		return amount;
	}

}
