package mt.edu.um;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;;

public class TransactionManager {
	
	public int numTransactionsProcessed;
	
	public HashMap<Integer, Long> map = new HashMap<Integer, Long>();  // long to keep track of time
	
	private ArrayList<Transaction> elements;
	
	public TransactionManager(){   

	}
	
	public TransactionManager(int src, int dst, long amount){   
		processTransaction(src,dst,amount);
	}
	
	//Atomic
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
	
	//Compound
	public boolean processTransaction(Transaction transaction) {
		elements = transaction.getElements();
		for (Transaction temp : elements) {
			Account source = AccountDatabase.getAccount(temp.getSourceAccountNumber());
			Account destination = AccountDatabase.getAccount(temp.getDestinationAccountNumber());
			
			if(!temp.process()){
				System.out.println("Failed at temp.process()");
				return false;
			}
			
			boolean boolSrc = true, boolDst = true;
			Date date = new Date();
			long now = date.getTime();     // storing current time

			if (map.containsKey(temp.getSourceAccountNumber())) {
				if (map.get(temp.getSourceAccountNumber()) > now){
					boolSrc = false;
				}
			}

			if (map.containsKey(temp.getDestinationAccountNumber())) {
				if (map.get(temp.getDestinationAccountNumber()) > now){
					boolDst = false;
				}
			}
			
			if (boolSrc && boolDst) {
				map.put(source.getAccountNumber(), now + 15000);    // keeping track of source account & time
				map.put(destination.getAccountNumber(), now + 15000);  // keeping track of destination account & time

				source.setAccountBalance(source.getAccountBalance() - temp.getAmount());  // transfer source
				destination.setAccountBalance(destination.getAccountBalance() + temp.getAmount()); // transfer destination
				
				++numTransactionsProcessed;
				return true;
			} 
			else
				return false;
		}
		return true;
	}
	
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
