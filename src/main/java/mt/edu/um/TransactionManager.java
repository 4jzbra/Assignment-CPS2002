package mt.edu.um;

import java.util.ArrayList;

public class TransactionManager {
	
	private int numTransactionsProcessed;
		
	public TransactionManager(){   

	}
	
	public TransactionManager(int src, int dst, long amount){   
		processTransaction(src,dst,amount);
	}
	
	public TransactionManager(CompoundTransaction transaction){   
		processTransaction(transaction);
	}
	
	//Atomic
	public boolean processTransaction(int src, int dst, long amount){
		Transaction transaction = new AtomicTransaction(src, dst, amount);
		
		try{
			transaction.process(); //since this can throw an exception, it was put in a try and catch block
		} catch(NullPointerException ex){
			throw ex;
		} catch(IllegalArgumentException ex){
			throw ex;
		}
		
		// if no exceptions are thrown, then this section will always be true
		Account source = AccountDatabase.getAccount(src);
		Account destination = AccountDatabase.getAccount(dst);

		source.setAccountBalance(source.getAccountBalance() - amount);  // transfer source
		destination.setAccountBalance(destination.getAccountBalance() + amount); // transfer destination
			
		++numTransactionsProcessed;
		
		return true;   
		
	}
	
	//Compound
	public boolean processTransaction(Transaction transaction) {
		CompoundTransaction compoundT = (CompoundTransaction) transaction;

		boolean bool = false;
		
		try{
			bool = compoundT.process();	
		}catch(IllegalArgumentException ex){
			throw ex;
		} 
		
		ArrayList<Transaction> elements = new ArrayList<Transaction>();
		elements.addAll(compoundT.getElements());
		if(bool){
			for (Transaction temp : elements) {
				if(temp instanceof AtomicTransaction){
					AtomicTransaction atomicT = (AtomicTransaction)temp;
					processTransaction(atomicT.getSourceAccountNumber(), atomicT.getDestinationAccountNumber(), atomicT.getAmount());
				} else{
					if(temp.process())
						processTransaction(temp);
				}
			}
			return true;
		}
		else return false;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
