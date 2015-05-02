package mt.edu.um;

public class TypicalCompound {    // using facade design pattern
	
	private Transaction deposit;
	private Transaction main;
	private Transaction commission;
	
	public TypicalCompound() { 
		deposit = new AtomicTransaction();
		main = new CompoundTransaction();
		commission = new CompoundTransaction();
	}
	
	//public processDeposit()
	


}
