package mt.edu.um;

public class LowRiskBuilder extends Builder {
	
	private final int DEP_SRC_ACCOUNT = 8665;
	private final int MAIN_SRC_ACCOUNT = 3133;
	private final int COMM_SRC_ACCOUNT = 6588;
	private final int COMM_DST_ACCOUNT = 4445;
		
	private CompoundTransaction compoundTransaction = null; 
	
	public LowRiskBuilder(String name) {
		compoundTransaction  = new CompoundTransaction(name);
	}
	
	public LowRiskBuilder() {
		compoundTransaction  = new CompoundTransaction();
	}
	
	public void buildDeposit(int dstAcc, long depositAmt){
		AtomicTransaction depositTrans = new AtomicTransaction();
		depositTrans.setSourceAccountNumber(DEP_SRC_ACCOUNT); //we need to create an account for this somewhere in the program
		depositTrans.setDestinationAccountNumber(dstAcc); //dest account here not specified
		depositTrans.setAmount(depositAmt);
		compoundTransaction.addTransaction(depositTrans);
	}                                         
	
	public void buildMainTransaction(int[] dstAccounts, long[] amounts){
		CompoundTransaction mainTrans = new CompoundTransaction("Main Transaction");
		for(int i = 0; i < dstAccounts.length && i < amounts.length; i++){
			AtomicTransaction atomicTrans = new AtomicTransaction(MAIN_SRC_ACCOUNT, dstAccounts[i], amounts[i]);
			mainTrans.addTransaction(atomicTrans);
		}		
	}
	
	public void buildCommission(long[] amounts){
		CompoundTransaction commisionTrans = new CompoundTransaction("Commission");
		for(long amt: amounts){
			long commission = (long)0.05*amt;
			AtomicTransaction atomicTrans = new AtomicTransaction(COMM_SRC_ACCOUNT, COMM_DST_ACCOUNT, commission);
			commisionTrans.addTransaction(atomicTrans);
		}	
	}
	
	public CompoundTransaction getWholeTransaction(){
		return compoundTransaction;  
	}

}
