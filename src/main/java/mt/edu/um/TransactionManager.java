package mt.edu.um;

import java.util.Date;

public class TransactionManager extends Transaction {
	
	private int numTransactionsProcessed;
	
	public TransactionManager(){   // default constructor

	}
	
	public TransactionManager(int src, int dst, long amt, int ntp){
		super(src, dst, amt);
		setNumTransactionsProcessed(ntp);
	}
	
	/*
	 * to calculate time:
	 * (note need to keep a reference of the account being involved)
	 * 
	 * long startOfTransaction1 = new Date.getTime()
	 * long startOfTransaction2 = new Date.getTime()
	 * long diff = startOfTransaction2 - startOfTransaction1
	 * 
	 * if (diff < 15) ret false...
	 */
	
	public boolean processTransaction(int src, int dst, long amount){
		
		
		return true;
	}
	
	public void setNumTransactionsProcessed(int ntp){
		numTransactionsProcessed += ntp;
	}
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}


}
