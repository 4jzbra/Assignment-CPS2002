package mt.edu.um;

public class TransactionFactory {
	
	public Transaction getTransaction(String type){
		if(type.equalsIgnoreCase("Compound")){
			return new CompoundTransaction();
		}
		else if(type.equalsIgnoreCase("Atomic")){
			return new AtomicTransaction();
		}
		else return null; 
	}
	
	// for typical compound transactions  (not sure about this!)
	public Transaction getDepositType(String type){
		if(type.equalsIgnoreCase("High Risk Deposit")){
			AtomicTransaction aT1 = new AtomicTransaction();
			aT1.setSourceAccountNumber(3123);
			return aT1;
		}
		else if(type.equalsIgnoreCase("Low Risk Deposit")){
			AtomicTransaction aT2 = new AtomicTransaction();
			aT2.setSourceAccountNumber(8665);
			return aT2;
		}
		else return null;
	}

}
