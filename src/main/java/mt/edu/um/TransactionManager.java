package mt.edu.um;

import java.util.Date;
import java.util.HashMap;;

public class TransactionManager extends Transaction {
	
	private static int numTransactionsProcessed;
	private static HashMap<Integer, Long> map = new HashMap<Integer, Long>();
	
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
		Date date = new Date();
		long now = date.getTime();

		if (map.containsKey(sourceAccountNumber)) {
			if (map.get(sourceAccountNumber) > now)
				System.out.println("Error: 15seconds have not passed");
				bool1 = false;
		}

		if (map.containsKey(destinationAccountNumber)) {
			if (map.get(destinationAccountNumber) > now)
				System.out.println("Error: 15 seconds have not passed");
				bool2 = false;
		}

		if ((process() == true) && bool1 && bool2) {
			map.put(source.getAccountNumber(), now + 15000);
			map.put(destination.getAccountNumber(), now + 15000);

			source.setAccountBalance(source.getAccountBalance() - amount);
			destination.setAccountBalance(destination.getAccountBalance()+ amount);
			numTransactionsProcessed++;
			System.out.println("Transaction Processed Succesfully");
			return true;
		} else
			return false;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
