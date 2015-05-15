package iterator;

import mt.edu.um.Transaction;

public interface TransactionIterator {
	
	public boolean hasNext();
	public Transaction next();
	
}
