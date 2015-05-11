package mt.edu.um;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TraverseTransactions  {
		
	private CompoundTransaction compoundTransaction;
	private List<Transaction> sortedElements;
	private int index;
	
	public TraverseTransactions() {}
	
	public TraverseTransactions(CompoundTransaction compoundTransaction){
		this.compoundTransaction = compoundTransaction;
		//this.elements = compoundTransaction.getAtomicElements();
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
	
	public boolean printAscendingOder(){
		sortedElements = new ArrayList<Transaction>();
		for(Iterator<Transaction> iter = compoundTransaction.createIterator(); iter.hasNext();){
			AtomicTransaction atomicTrans = (AtomicTransaction)iter.next();
			sortedElements.add(atomicTrans);
	      } 
		
		Collections.sort(sortedElements, new AtomicTransaction());
		
		for(int i = 0; i < sortedElements.size(); i++){
			AtomicTransaction at = (AtomicTransaction) sortedElements.get(i);
			System.out.println(i+1 + ". Transaction ");
			 System.out.println("Source: " + at.getSourceAccountNumber());
			 System.out.println("Destination: " + at.getDestinationAccountNumber());
			 System.out.println("Amount: " + at.getAmount()+"\n");
			
		}
		
		return true;
		
	}
	
	public boolean printDescendingOrder(){
		return false;
		
	}

}
