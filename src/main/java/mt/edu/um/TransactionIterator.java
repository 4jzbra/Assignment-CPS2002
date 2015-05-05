package mt.edu.um;

import java.util.Iterator;

public abstract interface TransactionIterator {
	
	public Iterator<Transaction> createIterator();
	
}

