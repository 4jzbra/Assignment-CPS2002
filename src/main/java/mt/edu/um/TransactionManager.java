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
	
	public TransactionManager(Transaction trans){   
		processTransaction(trans);
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
		System.out.println("no of elements "+ elements.size());
		for (Transaction temp : elements) {
			if(temp instanceof AtomicTransaction){
				processTransaction(temp.getSourceAccountNumber(), temp.getDestinationAccountNumber(), temp.getAmount());
			} else{
				processTransaction(temp);
			}
		}
		return true;
	}
	
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
