package mt.edu.um;

public class LowRiskBuilder {
	
	private Transaction compoundTransaction;
	
	public LowRiskBuilder() {}
	
	public void buildDeposit(){
		AtomicTransaction deposit = new AtomicTransaction();
		deposit.setSourceAccountNumber(8665);
	}
	
	
	

}
