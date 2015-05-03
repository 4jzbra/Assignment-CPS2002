package mt.edu.um;

import java.util.ArrayList;

public abstract class Builder {
	
	
	public abstract Transaction getWholeTransaction();
	
	public void buildDepost(){};
	
	public void buildMainTransaction(ArrayList<Integer> dstAccounts, ArrayList<Long> amounts){};
	
	public void buildCommision(){};
	
	
}
