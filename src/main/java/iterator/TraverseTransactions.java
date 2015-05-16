package iterator;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;

public class TraverseTransactions {
	
	private CompoundTransaction transaction;
	
	public TraverseTransactions(CompoundTransaction transaction){
		this.transaction = transaction;
	}
	
	public boolean printTransactions(){
		TransactionIterator compoundIterator = transaction.createIterator();
		System.out.println("Printing all transactions");
		return printTransactions(compoundIterator);
	}
	
	private boolean printTransactions(TransactionIterator iterator){
		while(iterator.hasNext()){
			AtomicTransaction atomicTrans = (AtomicTransaction)iterator.next();
			System.out.print("Source: " + atomicTrans.getSourceAccountNumber());
			System.out.print("   Destination: "+ atomicTrans.getDestinationAccountNumber());
			System.out.print("   Amount: " + atomicTrans.getAmount() + "\n");
		}
		return true;
	}

}
