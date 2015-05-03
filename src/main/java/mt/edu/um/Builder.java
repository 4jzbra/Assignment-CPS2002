package mt.edu.um;

public abstract class Builder {
	
	
	public abstract CompoundTransaction getWholeTransaction();
	
	public abstract void buildDeposit(int dstAcc, long depositAmt);
	
	public abstract void buildMainTransaction(int[] dstAccounts, long[] amounts);
	
	public abstract void buildCommission(long[] amounts);
	
	
}
