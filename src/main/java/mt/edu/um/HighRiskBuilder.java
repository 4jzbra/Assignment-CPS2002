package mt.edu.um;

import java.util.ArrayList;


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
	
	public void buildDeposit(){
		AtomicTransaction depositTrans = new AtomicTransaction();
		depositTrans.setSourceAccountNumber(DEP_SRC_ACCOUNT); //we need to create an account for this somewhere in the program
		compoundTransaction.addTransaction(depositTrans);
	}                                         
	
	public void buildMainTransaction(int[] dstAccounts, long[] amounts){
		CompoundTransaction mainTrans = new CompoundTransaction("Main Transaction");
		for(int i = 0; i < dstAccounts.length && i < amounts.length; i++){
			AtomicTransaction atomicTrans = new AtomicTransaction(MAIN_SRC_ACCOUNT, dstAccounts[i], amounts[i]);
			mainTrans.addTransaction(atomicTrans);
		}		
	}
	
	public void buildCommision(long[] amounts){
		CompoundTransaction commisionTrans = new CompoundTransaction("Commission");
		for(long amt: amounts){
			long commission = (long)0.1*amt;
			AtomicTransaction atomicTrans = new AtomicTransaction(COMM_SRC_ACCOUNT, COMM_DST_ACCOUNT, commission);
			commisionTrans.addTransaction(atomicTrans);
		}	
	}
	
	public Transaction getWholeTransaction(){
		return compoundTransaction;  
	}

}
