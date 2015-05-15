package mt.edu.um;

import iterator.CompoundTransactionIterator;
import iterator.TransactionIterator;

import java.util.ArrayList;

public class CompoundTransaction implements Transaction{
	private String name; 
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
	
	public TransactionIterator createIterator(){
		return new CompoundTransactionIterator(elements);
	}

}
