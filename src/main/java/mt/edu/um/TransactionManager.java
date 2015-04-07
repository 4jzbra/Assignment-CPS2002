package mt.edu.um;

import java.util.Date;
import java.util.HashMap;;

public class TransactionManager extends Transaction {
	
	private int numTransactionsProcessed;
	private HashMap<Integer, Long> map = new HashMap<Integer, Long>();
	
	public TransactionManager(){   

	}
	
	public TransactionManager(int src, int dst, long amt){
		super(src, dst, amt);
		processTransaction(src, dst, amt);
	}
	
	public boolean processTransaction(int src, int dst, long amount){
		Account source = AccountDatabase.getAccount(sourceAccountNumber);
		Account destination = AccountDatabase.getAccount(destinationAccountNumber);

		boolean bool1 = true, bool2 = true;
		long now = new Date().getTime();

		if (map.containsKey(sourceAccountNumber)) {
			if (map.get(sourceAccountNumber) < now)
				bool1 = false;
		}

		if (map.containsKey(destination)) {
			if (map.get(destinationAccountNumber) < now)
				bool2 = false;
		}

		if ((process() == true) && bool1 && bool2) {
			map.put(source.getAccountNumber(), now + 15000);
			map.put(destination.getAccountNumber(), now + 15000);

			source.setAccountBalance(source.getAccountBalance() - amount);
			destination.setAccountBalance(destination.getAccountBalance()+ amount);
			numTransactionsProcessed++;
			return true;
		} else
			return false;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
