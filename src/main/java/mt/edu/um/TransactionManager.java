package mt.edu.um;
import java.util.Date;

public class TransactionManager extends Transaction {
	
	private int numTransactionsProcessed;
	
	public TransactionManager(){   // default constructor

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
	
	public void setNumTransactionsProcessed(){
		numTransactionsProcessed++;
	}
	
	public int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
