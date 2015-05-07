package mt.edu.um;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class TraverseTransactions implements Comparator<Transaction> {
		
	private CompoundTransaction compoundTransaction;
	private ArrayList<Transaction> elements;
	private int index;
	
	
	public TraverseTransactions() {}
	
	public TraverseTransactions(CompoundTransaction compoundTransaction){
		this.compoundTransaction = compoundTransaction;
		this.elements = compoundTransaction.getAtomicElements();
		index = 1;
	}
	
	/*public boolean traverse(){
		Iterator<Transaction> AtomicT = transIter.createIterator();
		
		if (printTransaction(AtomicT)) return true;
		
		else return false;
	}*/
	
	public boolean printTransaction(){ // STILL NEEDS SORTING
			
		for(Iterator<Transaction> iter = compoundTransaction.createIterator(); iter.hasNext();){
			AtomicTransaction atomicTrans = (AtomicTransaction)iter.next();
	         System.out.println("-----USING ITERATOR-----");
	         System.out.println(this.index++ + ". Transaction ");
			 System.out.println("Source: " + atomicTrans.getSourceAccountNumber());
			 System.out.println("Destination: " + atomicTrans.getDestinationAccountNumber());
			 System.out.println("Amount: " + atomicTrans.getAmount()+"\n");
	      } 
		
		return true;
	}


	@Override
	public int compare(Transaction t1, Transaction t2) {
		AtomicTransaction at1 = (AtomicTransaction) t1;
		AtomicTransaction at2 = (AtomicTransaction) t2;
		if(at1.getAmount() < at2.getAmount()) return -1;
		else if(at1.getAmount() == at2.getAmount()) return 0;
		else return 1;
	}

}
