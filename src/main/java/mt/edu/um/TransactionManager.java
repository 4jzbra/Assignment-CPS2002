package mt.edu.um;

public class TransactionManager extends Transaction {
	
	private int numTransactionsProcessed;
	
	public TransactionManager(){

	}
	
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
