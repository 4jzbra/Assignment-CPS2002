package mt.edu.um;
import java.lang.NullPointerException;

public class AtomicTransaction implements Transaction {   // the leaf of the composite design pattern
		
	private int sourceAccountNumber; 
	private int destinationAccountNumber;
	private long amount;
	
	public AtomicTransaction(){	}
	
	public AtomicTransaction(int src, int dst, long amt) {
		setSourceAccountNumber(src);
		setDestinationAccountNumber(dst);
		setAmount(amt);
	}	
	
		
	public boolean process() {
		Account source = AccountDatabase.getAccount(getSourceAccountNumber());
		Account destination = AccountDatabase.getAccount(getDestinationAccountNumber());
		
		if (source == null || destination == null) { 
			System.out.println("source "+source.getAccountNumber());
			System.out.println("destination "+destination.getAccountNumber());
			throw new NullPointerException();
		}
		
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - getAmount()) >= 0) {
			System.out.println("AtomicTransaction status: true");
			return true;
		} 
		else {
			System.out.println("AtomicTransaction status: false");
			throw new IllegalArgumentException("ERROR IN TRANSACTION!");
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
