package mt.edu.um;

import java.util.Date;
import java.util.HashMap;;

public class TransactionManager {
	
	private static int numTransactionsProcessed;
	private static HashMap<Integer, Long> map = new HashMap<Integer, Long>();  // long to keep track of time
	
	public TransactionManager(){   

	}
	
	public TransactionManager(int src, int dst, long amt){
		processTransaction(src, dst, amt);
	}
	
	// method that ensures that transaction is valid (including that an account is not involved
	// in more that 1 transaction every 15 seconds
	public boolean processTransaction(int src, int dst, long amount){
		Transaction transaction = new Transaction(src, dst, amount);
		Account source = AccountDatabase.getAccount(src);
		Account destination = AccountDatabase.getAccount(dst);

		boolean boolSrc = true, boolDst = true;
		Date date = new Date();
		long now = date.getTime();

		if (map.containsKey(src)) {
			if (map.get(src) > now){
				System.out.println("Error: 15 seconds have not passed");
				boolSrc = false;
			}
		}

		if (map.containsKey(dst)) {
			if (map.get(dst) > now){
				System.out.println("Error: 15 seconds have not passed");
				boolDst = false;
			}
		}
		
		if ((transaction.process() == true) && boolSrc && boolDst) {
			map.put(source.getAccountNumber(), now + 15000);    // keeping track of source account & time
			map.put(destination.getAccountNumber(), now + 15000);  // keeping track of destination account & time

			source.setAccountBalance(source.getAccountBalance() - amount);  // transfer source
			destination.setAccountBalance(destination.getAccountBalance() + amount); // transfer destination
			
			++numTransactionsProcessed;
			System.out.println("Transaction Processed Succesfully");
			return true;
		} 
		else
			return false;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
