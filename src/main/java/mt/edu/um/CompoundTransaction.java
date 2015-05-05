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
    public ArrayList<Transaction> getAtomicElements(){
            ArrayList<Transaction> ele = new ArrayList<Transaction>();
            
            for(int i = 0; i < elements.size(); ++i) {
                Transaction t = elements.get(i);
                
                if (t instanceof AtomicTransaction) {
                    ele.add(t);
                }
                else {
                    ele.addAll(((CompoundTransaction)t).getElements());
                }

            } 
            return  ele;
            
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
