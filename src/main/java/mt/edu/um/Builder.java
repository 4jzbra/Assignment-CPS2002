package mt.edu.um;

public abstract class Builder {
	
	
	public abstract Transaction getWholeTransaction();
	
	public void buildDepost(){};
	
	public void buildMainTransaction(int[] dstAccounts, long[] amounts){};
	
	public void buildCommision(){};
	
	
}
