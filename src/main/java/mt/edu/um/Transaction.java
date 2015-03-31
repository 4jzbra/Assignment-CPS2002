package mt.edu.um;

public class Transaction {

	private int sourceAccountNumber;
	private int destinationAccountNumber;
	private long amount;
	
	public Transaction(){
		
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
	
	public int getSourceAccountNumber(){
		return sourceAccountNumber;
	}
	
	public void setDestinationAccountNumber(int accNo) {
		destinationAccountNumber = accNo;
	}
	
	public int getDestinationAccountNumber(){
		return destinationAccountNumber;
	}
	
	public void setAmount(long amt){
		amount = amt;
	}
	
	public long getAmount(){
		return amount;
	}

}
