package mt.edu.um;

public class HighRiskBuilder extends Builder {
	
	private Transaction compoundTransaction; //not sure if we need this
	
	public HighRiskBuilder() {}
	
	public void buildDeposit(){
		AtomicTransaction deposit = new AtomicTransaction();
		deposit.setSourceAccountNumber(3123); //we need to create an account for this somewhere in the program
	}                                         
	
	public void buildMainTransaction(){};
	
	public void buildCommision(){};
	
	public Transaction getWholeTransaction(){
		return compoundTransaction;  /////
	}

}
