package mt.edu.um;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;;

public class TransactionManager {
	
	private static int numTransactionsProcessed;
	
	//private static HashMap<Integer, Long> map = new HashMap<Integer, Long>();  // long to keep track of time
	
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
		//Transaction transaction = new AtomicTransaction(src, dst, amount);
		Account source = AccountDatabase.getAccount(src);
		Account destination = AccountDatabase.getAccount(dst);

		source.setAccountBalance(source.getAccountBalance() - amount);  // transfer source
		destination.setAccountBalance(destination.getAccountBalance() + amount); // transfer destination
			
		++numTransactionsProcessed;
		return true;
	}
	
	//Compound
	public boolean processTransaction(Transaction transaction) {
		ArrayList<Transaction> elements;
		CompoundTransaction trans;
		trans = (CompoundTransaction) transaction; //try
		elements = trans.getElements();
		
		
		AtomicTransaction at;
		
		for (Transaction temp : elements) {
			
			if(temp instanceof AtomicTransaction){
				at = (AtomicTransaction)temp;
				processTransaction(at.getSourceAccountNumber(), at.getDestinationAccountNumber(), at.getAmount());
			} else{
				
				if(temp.process())
					processTransaction(temp);
			}
		}
		return true;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
