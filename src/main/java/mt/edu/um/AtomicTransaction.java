package mt.edu.um;
import java.lang.NullPointerException;

public class AtomicTransaction extends Transaction {   // the leaf of the composite design pattern
		
	
	public AtomicTransaction(){	}
	
	public AtomicTransaction(int src, int dst, long amt) {
		super(src, dst, amt);
		//process();
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
			return true;
		} 
		else {
			throw new IllegalArgumentException("ERROR IN TRANSACTION!");
		}
	}
}
