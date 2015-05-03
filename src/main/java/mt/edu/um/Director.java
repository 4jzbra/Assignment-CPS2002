package mt.edu.um;

public class Director {
	
	public CompoundTransaction createTransaction(String type, int[] dstAccounts, long[] amounts){
		CompoundTransaction trans = null;
		
		if(type.equalsIgnoreCase("high")){
			System.out.println("high");
			Builder builder = new HighRiskBuilder();
			builder.buildDepost();
			builder.buildMainTransaction(dstAccounts, amounts);
			builder.buildCommision();
			trans = builder.getWholeTransaction();
		}else if(type.equalsIgnoreCase("low")){
			Builder builder = new LowRiskBuilder();
			builder.buildDepost();
			builder.buildMainTransaction(dstAccounts, amounts);
			builder.buildCommision();
			trans = builder.getWholeTransaction();
		}
		
		return trans;
	}

}
