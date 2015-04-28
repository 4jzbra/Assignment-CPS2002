package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction extends Transaction{
	// using composite design pattern - tree of transactions
	
	//private String name;   // name of compound transaction << din nahseb imbad niehdu hsieba bil-factory pattern wara li nehilsu composite
	
	private ArrayList<Transaction> elements;
	
	
	public CompoundTransaction(int src, int dst, long amt){
		super(src, dst, amt); //not sure about this
		elements = new ArrayList<Transaction>();
	}
	
	//adding atomic and/or compound transactions to the ArrayList
	public void addTransaction(Transaction transaction){
		elements.add(transaction);
	}

	// process for a compound transaction
	public boolean process() {
		//for all transactions in elements, element.process()
		return false;
	}
	
	

}
