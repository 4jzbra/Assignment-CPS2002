package iterator;

import java.util.ArrayList;
import java.util.Collections;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;

// this class prints lowest amount first
public class CriteriaIncAmounts implements Criteria {
	
	public boolean meetCriteria(CompoundTransaction transaction){
		ArrayList<AtomicTransaction> increasingOrder = new ArrayList<AtomicTransaction>();
		TransactionIterator compoundIterator = transaction.createIterator();
		
		while(compoundIterator.hasNext()){
			AtomicTransaction atomicTrans = (AtomicTransaction)compoundIterator.next();
			increasingOrder.add(atomicTrans);
		}
		
		Collections.sort(increasingOrder, new AtomicTransaction());
		
		PrintTransactions print = new PrintTransactions();
		print.printTransactions(increasingOrder);
		
		return true;
	}
	
}
