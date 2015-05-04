package mt.edu.um;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HighRiskBuilderTest {
	
	private Builder highRisk,
					highRisk2;
	
	@Before
	public void init(){
		highRisk = new HighRiskBuilder();
		highRisk2 = new HighRiskBuilder("High risk transfer");
	}
	
	@Test
	public void buildDepositTest(){
		Assert.assertEquals(true, highRisk.buildDeposit(9, 3000)); //checking if account exists is handled by the TransactionManager
	}
	
	@Test
	public void buildMainTransactionTest(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400};
		Assert.assertEquals(true, highRisk.buildMainTransaction(dstAccounts, amounts));
	}
	
	@Test
	public void buildCommission(){
    	long[] amounts = {200,400,3000,2300,400};
		Assert.assertEquals(true, highRisk.buildCommission(amounts));
	}
	
	@Test
	public void getWholeTransactionTest(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400};
		highRisk.buildDeposit(4, 500);
		highRisk.buildMainTransaction(dstAccounts, amounts);
		highRisk.buildCommission(amounts);
		
		CompoundTransaction transaction = highRisk.getWholeTransaction();
		Assert.assertEquals(3,transaction.getElements().size()); //deposit, main & commission = 3 elements 
	}
	
	@Test
	public void ConstructorTest(){     // testing constructor - name of compound transaction
		final String name = "High risk transfer";
		CompoundTransaction ct = highRisk2.getWholeTransaction();
		Assert.assertEquals(name, ct.getName());
	}
}
