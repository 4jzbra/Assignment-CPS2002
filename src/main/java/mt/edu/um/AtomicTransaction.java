package mt.edu.um;
import java.lang.NullPointerException;
import java.util.Comparator;

public class AtomicTransaction implements Transaction, Comparator<Transaction>{   // the leaf of the composite design pattern
		
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
		
		if (source == null) { 
			throw new NullPointerException("Source account "+getSourceAccountNumber()+" does not exist.");
		} else if(destination == null){
			throw new NullPointerException("Destination account "+getDestinationAccountNumber()+" does not exist.");
		}
		
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - getAmount()) >= 0) {
			return true;
		} 
		else {
			throw new IllegalArgumentException("Insufficient balance");
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

	@Override
	public int compare(Transaction t1, Transaction t2) {
		AtomicTransaction at1 = (AtomicTransaction) t1;
		AtomicTransaction at2 = (AtomicTransaction) t2;
		if(at1.getAmount() < at2.getAmount()) return -1;
		else if(at1.getAmount() == at2.getAmount()) return 0;
		else return 1;
	}
}
