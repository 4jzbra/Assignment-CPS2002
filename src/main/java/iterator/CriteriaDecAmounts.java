package iterator;

import java.util.ArrayList;
import java.util.Collections;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;

//this class prints highest amount first
public class CriteriaDecAmounts implements Criteria {
	
	public boolean meetCriteria(CompoundTransaction transaction){
		ArrayList<AtomicTransaction> descreasingOrder = new ArrayList<AtomicTransaction>();
		ArrayList<AtomicTransaction> tempArray = new ArrayList<AtomicTransaction>();
		TransactionIterator compoundIterator = transaction.createIterator();
		
		while(compoundIterator.hasNext()){
			AtomicTransaction atomicTrans = (AtomicTransaction)compoundIterator.next();
			tempArray.add(atomicTrans);
		}
		
		Collections.sort(tempArray, new AtomicTransaction());
		
		for(int i = tempArray.size()-1; i >= 0; i--){
			descreasingOrder.add(tempArray.get(i));
		}
		
		PrintTransactions print = new PrintTransactions();
		print.printTransactions(descreasingOrder);
		
		return true;
	}
	
}
