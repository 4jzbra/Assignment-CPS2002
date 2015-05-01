package mt.edu.um;

import java.util.ArrayList;

public class TransactionManager {
	
	private static int numTransactionsProcessed;
		
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
		boolean bool = false;
		
		try{
			bool = transaction.process(); //since this can throw an exception, it was put in a try and catch block
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		if(bool){
			Account source = AccountDatabase.getAccount(src);
			Account destination = AccountDatabase.getAccount(dst);
	
			source.setAccountBalance(source.getAccountBalance() - amount);  // transfer source
			destination.setAccountBalance(destination.getAccountBalance() + amount); // transfer destination
				
			++numTransactionsProcessed;
			
			return true;
		} else return false;
	}
	
	//Compound
	public boolean processTransaction(Transaction transaction) {
		CompoundTransaction compoundT = (CompoundTransaction) transaction;

		boolean bool = false;
		
		try{
			bool = compoundT.process();	
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException(e.getMessage());
		} 
		
		ArrayList<Transaction> elements = compoundT.getElements();
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
