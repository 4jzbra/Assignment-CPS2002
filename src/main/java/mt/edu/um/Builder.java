package mt.edu.um;

import java.util.ArrayList;

public abstract class Builder {
	
	static Builder getRiskBuilder(String risk){
		
		//need to implement
		return null;
	}
	
	public void buildDepost(){};
	
	public void buildMainTransaction(ArrayList<Integer> dstAccounts, ArrayList<Long> amounts){};
	
	public void buildCommision(){};
	
	
}
