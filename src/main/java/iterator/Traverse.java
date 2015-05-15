package iterator;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;

public class Traverse {
	
	private CompoundTransaction transaction;
	
	public Traverse(CompoundTransaction transaction){
		this.transaction = transaction;
	}
	
	public void printTransactions(){
		TransactionIterator compoundIterator = transaction.createIterator();
		System.out.println("Printing all transactions");
		printTransactions(compoundIterator);
	}
	
	private void printTransactions(TransactionIterator iterator){
		while(iterator.hasNext()){
			AtomicTransaction atomicTrans = (AtomicTransaction)iterator.next();
			System.out.print("Source: " + atomicTrans.getSourceAccountNumber());
			System.out.print("   Destination: "+ atomicTrans.getDestinationAccountNumber());
			System.out.print("   Amount: " + atomicTrans.getAmount() + "\n");
		}
	}

}
