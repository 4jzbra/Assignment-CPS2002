package mt.edu.um;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;;

public abstract class TransactionManager {
	
	public int numTransactionsProcessed;
	
	public HashMap<Integer, Long> map = new HashMap<Integer, Long>();  // long to keep track of time
	
	
	public TransactionManager(){   

	}
	
	public boolean processTransaction(int src, int dst, long amount){
		throw new UnsupportedOperationException();
	}
	
	public boolean processTransaction(Transaction transaction) {
		throw new UnsupportedOperationException();
	}
	
	
	int getNumTransactionsProcessed(){
		return numTransactionsProcessed;
	}

}
