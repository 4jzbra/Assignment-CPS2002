package mt.edu.um;

public class AtomicTransaction {   // the leaf of the composite design pattern
		
	private Transaction leaf;  // the actual transaction (with src, dst...)
	
	public AtomicTransaction(){
		
	}
}
