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
	
	// returns all the leaves found inside a compound transaction
    public ArrayList<Transaction> getAtomicElements(){  // not sure if this method should be here
            ArrayList<Transaction> atomicTransactions = new ArrayList<Transaction>();
            System.out.println(getName()+"all elements: "+elements.size());
            for(int i = 0; i < elements.size(); ++i) {
                Transaction t = elements.get(i);
                
                if (t instanceof AtomicTransaction) {
                    atomicTransactions.add(t);
                }
                else {
                    atomicTransactions.addAll(((CompoundTransaction)t).getAtomicElements()); //since there could be a compound transaction within another
                }
            } 
            
            return  atomicTransactions;     
    }
	
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public Iterator<Transaction> createIterator(){
        elements = getAtomicElements();
		return elements.iterator();
	}




}
