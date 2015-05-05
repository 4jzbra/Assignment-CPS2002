package mt.edu.um;

import java.util.ArrayList;
import java.util.Iterator;

public class CompoundTransaction implements Transaction, TransactionIterator{
	private String name;   // name of compound transaction
	private ArrayList<Transaction> elements = new ArrayList<Transaction>();
	
	public CompoundTransaction(){

	}
	
	public CompoundTransaction(String n){ 
		setName(n);
	}
	
	// adding atomic and/or compound transactions to the ArrayList, does not allow duplicate transactions
	public boolean addTransaction(Transaction transaction){
		if(elements.contains(transaction)) return false;
		else return elements.add(transaction);
	}

	public boolean process() {
		if(elements.isEmpty()) throw new IllegalArgumentException("Compound transaction has no elements.");
		return true;
	}
	
	public ArrayList<Transaction> getElements(){
		return elements;
	}
	
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public Iterator<Transaction> createIterator(){
		return elements.iterator();
	}


}
