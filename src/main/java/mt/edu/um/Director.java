package mt.edu.um;

import java.util.ArrayList;

public class Director {
	
	public Transaction createTransaction(String type, ArrayList<Integer> dstAccounts, ArrayList<Long> amounts){
		Transaction trans = null;
		
		if(type.equalsIgnoreCase("high")){
			Builder builder = new HighRiskBuilder(dstAccounts, amounts);
			trans = builder.getWholeTransaction();
		}else if(type.equalsIgnoreCase("low")){
			Builder builder = new LowRiskBuilder(dstAccounts, amounts);
			trans = builder.getWholeTransaction();
		}
		
		return trans;
	}

}
