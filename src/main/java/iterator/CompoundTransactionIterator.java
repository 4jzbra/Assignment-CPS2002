package iterator;
import java.util.ArrayList;

import mt.edu.um.CompoundTransaction;
import mt.edu.um.Transaction;


public class CompoundTransactionIterator implements TransactionIterator {
	private final ArrayList<Transaction> items = new ArrayList<Transaction>();
	private int currentIndex = 0;
	
	public CompoundTransactionIterator(ArrayList<Transaction> items){
		this.items.addAll(items);
	}
	
        @Override
	public boolean hasNext() {
		if((currentIndex < items.size()) && (items.get(currentIndex) instanceof CompoundTransaction)){
			CompoundTransaction temp = (CompoundTransaction) items.get(currentIndex);
			currentIndex += 1; //skip this compound transaction in items
			items.addAll(temp.getElements()); 
			return this.hasNext();
		}
                
            return currentIndex < items.size();
	}

        @Override
	public Transaction next() {
		Transaction transaction = items.get(currentIndex);
		currentIndex += 1;
		return transaction;
	}

}
