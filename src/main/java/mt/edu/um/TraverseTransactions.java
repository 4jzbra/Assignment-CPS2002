package mt.edu.um;

import java.util.Iterator;

public class TraverseTransactions {
		
	private TransactionIterator transIter;
	
	
	public TraverseTransactions() {}
	
	public TraverseTransactions(TransactionIterator ti){
		transIter = ti;
	}
	
	public void traverse(){
		Iterator<Transaction> AtomicT = transIter.createIterator();
		
		printTransaction(AtomicT);
		
	}
	
	public void printTransaction(Iterator<Transaction> iter){  // still needs to be fixed
		
		while(iter.hasNext()){
			if (iter.next() instanceof CompoundTransaction) continue;
			else{
				AtomicTransaction t = (AtomicTransaction) iter.next();
				System.out.println("-----USING ITERATOR-----");
				System.out.println("Source: " + t.getSourceAccountNumber());
				System.out.println("Destination: " + t.getDestinationAccountNumber());
				System.out.println("Amount: " + t.getAmount());
			}
		}
	}
}
