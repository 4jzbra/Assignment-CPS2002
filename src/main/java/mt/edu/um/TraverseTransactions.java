package mt.edu.um;

import java.util.Iterator;

public class TraverseTransactions {
		
	private TransactionIterator transIter;
	
	
	public TraverseTransactions() {}
	
	public TraverseTransactions(TransactionIterator ti){
		transIter = ti;
	}
	
	public boolean traverse(){
		Iterator<Transaction> AtomicT = transIter.createIterator();
		
		if (printTransaction(AtomicT)) return true;
		
		else return false;
		
	}
	
	public boolean printTransaction(Iterator<Transaction> iter){ // STILL NEEDS SORTING
		
		while(iter.hasNext()){
			//if (iter instanceof CompoundTransaction) { }
			if (iter instanceof Iterator){
				AtomicTransaction t = (AtomicTransaction) iter.next();
				System.out.println("-----USING ITERATOR-----");
				System.out.println("Source: " + t.getSourceAccountNumber());
				System.out.println("Destination: " + t.getDestinationAccountNumber());
				System.out.println("Amount: " + t.getAmount());
			}
			else return false;
		}
		return true;
	}
}
