package iterator;

import java.util.ArrayList;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;

public class FilterBySrcAccNo implements Filter{

        @Override
	public boolean meetCriteria(CompoundTransaction transaction, int accNo) {
		ArrayList<AtomicTransaction> filtered = new ArrayList<AtomicTransaction>();
		TransactionIterator compoundIterator = transaction.createIterator();
		
		while(compoundIterator.hasNext()){
			AtomicTransaction atomicTrans = (AtomicTransaction)compoundIterator.next();
			if(atomicTrans.getSourceAccountNumber() == accNo) filtered.add(atomicTrans);
		}
		PrintTransactions print = new PrintTransactions();
		print.printTransactions(filtered);
		return false;
	}

}
