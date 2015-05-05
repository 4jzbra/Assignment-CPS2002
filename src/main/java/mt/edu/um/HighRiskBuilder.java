package mt.edu.um;

public class HighRiskBuilder extends Builder {
	
	private final int DEP_SRC_ACCOUNT = 3123;
	private final int MAIN_SRC_ACCOUNT = 3143;
	private final int COMM_SRC_ACCOUNT = 6565;
	private final int COMM_DST_ACCOUNT = 4444;
		
	private CompoundTransaction compoundTransaction = null; 
	
	public HighRiskBuilder(){
		compoundTransaction  = new CompoundTransaction();
	}
	
	public HighRiskBuilder(String name) {
		compoundTransaction  = new CompoundTransaction(name);
	}
	
	
	@Override
	public boolean buildDeposit(int dstAcc, long depositAmt){
		AtomicTransaction depositTrans = new AtomicTransaction();
		depositTrans.setSourceAccountNumber(DEP_SRC_ACCOUNT); //we need to create an account for this somewhere in the program
		depositTrans.setDestinationAccountNumber(dstAcc); 
		depositTrans.setAmount(depositAmt);
		return compoundTransaction.addTransaction(depositTrans);
	}                                         
	
	@Override
	public boolean buildMainTransaction(int[] dstAccounts, long[] amounts){
		CompoundTransaction mainTrans = new CompoundTransaction("Main Transaction");
		for(int i = 0; i < dstAccounts.length && i < amounts.length; ++i){
			AtomicTransaction atomicTrans = new AtomicTransaction(MAIN_SRC_ACCOUNT, dstAccounts[i], amounts[i]);
			mainTrans.addTransaction(atomicTrans);
		}		
		return compoundTransaction.addTransaction(mainTrans);
	}
	
	@Override
	public boolean buildCommission(long[] amounts){
		CompoundTransaction commissionTrans = new CompoundTransaction("Commission");
		// here not sure if there should be a transaction for a commission for every element in the main transaction
		for(int i = 0; i < amounts.length; ++i){
			double commission = 0.1*amounts[i];
			System.out.println("commission "+commission);
			AtomicTransaction atomicTrans = new AtomicTransaction(COMM_SRC_ACCOUNT, COMM_DST_ACCOUNT, (long)commission);
			commissionTrans.addTransaction(atomicTrans);
		}	
		return compoundTransaction.addTransaction(commissionTrans);
	}
	
	@Override
	public CompoundTransaction getWholeTransaction(){
		return compoundTransaction;  
	}



}
