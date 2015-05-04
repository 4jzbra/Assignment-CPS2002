package mt.edu.um;

public abstract class Builder {
	
	public abstract boolean buildDeposit(int dstAcc, long depositAmt);
	
	public abstract boolean buildMainTransaction(int[] dstAccounts, long[] amounts);
	
	public abstract boolean buildCommission(long[] amounts);
	
	public abstract CompoundTransaction getWholeTransaction();
	
}
