package mt.edu.um;

import java.util.Date;

//handles the processTransaction of Atomic transaction
public class AtomicTransactionManager extends TransactionManager {
	
	public AtomicTransactionManager(){
		
	}
	
	public AtomicTransactionManager(int src, int dst, long amt){
		processTransaction(src, dst, amt);
	}
	
	public boolean processTransaction(int src, int dst, long amount){
		Transaction transaction = new AtomicTransaction(src, dst, amount);
		Account source = AccountDatabase.getAccount(src);
		Account destination = AccountDatabase.getAccount(dst);
		
		if (transaction.process() == false){
			return false;
		}

		boolean boolSrc = true, boolDst = true;
		Date date = new Date();
		long now = date.getTime();     // storing current time

		if (map.containsKey(src)) {
			if (map.get(src) > now){
				boolSrc = false;
			}
		}

		if (map.containsKey(dst)) {
			if (map.get(dst) > now){
				boolDst = false;
			}
		}
		
		if (boolSrc && boolDst) {
			map.put(source.getAccountNumber(), now + 15000);    // keeping track of source account & time
			map.put(destination.getAccountNumber(), now + 15000);  // keeping track of destination account & time

			source.setAccountBalance(source.getAccountBalance() - amount);  // transfer source
			destination.setAccountBalance(destination.getAccountBalance() + amount); // transfer destination
			
			++numTransactionsProcessed;
			return true;
		} 
		else
			return false;
	}

}
