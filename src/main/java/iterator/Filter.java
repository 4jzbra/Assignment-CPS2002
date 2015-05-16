package iterator;

import mt.edu.um.CompoundTransaction;

public interface Filter {
	
	public abstract boolean meetCriteria(CompoundTransaction transaction, int accNo);
	
}

