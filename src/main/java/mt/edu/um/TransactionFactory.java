package mt.edu.um;

public class TransactionFactory {
	
	public Transaction getTransaction(String type){
		if(type.equalsIgnoreCase("Compound")){
			return new CompoundTransaction();
		}
		else if(type.equalsIgnoreCase("Atomic")){
			return new AtomicTransaction();
		}
		else return null;  // or exception?
	}

}
