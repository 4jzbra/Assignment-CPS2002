package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction extends Transaction{
	// using composite design pattern
	
	//private String name;   // name of compound transaction << din nahseb imbad niehdu hsieba bil-factory pattern wara li nehilsu composite
	
	private ArrayList<Transaction> elements;
	
	public CompoundTransaction(){
		
	}
	
	// not sure about this constructor
	public CompoundTransaction(int src, int dst, long amt){
		super(src, dst, amt); 
		elements = new ArrayList<Transaction>();
	}
	
	// adding atomic and/or compound transactions to the ArrayList
	public void addTransaction(Transaction transaction){
		elements.add(transaction);
	}

	// process for a compound transaction
	public boolean process() {
		// for all transactions in elements, transaction.process()
		for(Transaction transaction: elements){
			if(!transaction.process()) throw new SecurityException ("ERROR IN TRANSACTION");
		}
		return true;
	}

}
