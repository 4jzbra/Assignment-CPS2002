package mt.edu.um;

public class AtomicTransaction extends Transaction {   // the leaf of the composite design pattern
		
	
	public AtomicTransaction(){	}
	
	public AtomicTransaction(int src, int dst, long amt) {
		super(src, dst, amt);
	}	
	
	public boolean process() {
		Account source = AccountDatabase.getAccount(getSourceAccountNumber());
		Account destination = AccountDatabase.getAccount(getDestinationAccountNumber());
		
		if (source == null || destination == null) { 
			return false;
		}
		
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - getAmount()) >= 0) {
			return true;
		} 
		else {
			return false;
		}
	}
}
