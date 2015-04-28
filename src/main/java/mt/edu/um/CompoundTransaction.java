package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction extends Transaction{
	// using composite design pattern
	
	private String name;   // name of compound transaction
	
	private ArrayList<Transaction> elements;
	
	public CompoundTransaction(){
		
	}
	
	public CompoundTransaction(String n){ 
		setName(n);
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
			if(!transaction.process()) throw new IllegalArgumentException ("ERROR IN TRANSACTION");
		}
		return true;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}

}
