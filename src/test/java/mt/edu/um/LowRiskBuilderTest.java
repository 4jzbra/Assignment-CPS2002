package mt.edu.um;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowRiskBuilderTest {
	
	private Builder lowRisk;
	
	@Before
	public void init(){
		lowRisk = new LowRiskBuilder();
	}
	
	@Test
	public void buildDepositTest(){
		Assert.assertEquals(true, lowRisk.buildDeposit(9, 3000)); //checking if account exists is handled by the TransactionManager
	}
	
	@Test
	public void buildMainTransactionTest(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400};
		Assert.assertEquals(true, lowRisk.buildMainTransaction(dstAccounts, amounts));
	}
	
	@Test
	public void buildCommissionTest(){
    	long[] amounts = {200,400,3000,2300,400};
		Assert.assertEquals(true, lowRisk.buildCommission(amounts));
	}
	
	@Test
	public void getWholeTransactionTest(){
		int[] dstAccounts = {1,2,3,4,5};
    	long[] amounts = {200,400,3000,2300,400};
    	lowRisk.buildDeposit(4, 500);
    	lowRisk.buildMainTransaction(dstAccounts, amounts);
    	lowRisk.buildCommission(amounts);
		
		CompoundTransaction transaction = lowRisk.getWholeTransaction();
		Assert.assertEquals(3, transaction.getElements().size()); //deposit, main & commission = 3 elements 
	}
	
	@Test
	public void ConstructorTest(){
		CompoundTransaction ct  = new CompoundTransaction("Low risk transfer");
		final String name = "Low risk transfer";
		Assert.assertEquals(name, ct.getName());
	}
}
