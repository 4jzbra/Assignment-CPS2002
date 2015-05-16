package iterator;

import mt.edu.um.CompoundTransaction;


public interface Criteria {
	
	public abstract boolean meetCriteria(CompoundTransaction transaction);
	
}
