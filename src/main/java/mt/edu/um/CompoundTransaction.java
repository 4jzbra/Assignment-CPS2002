package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction implements Transaction{
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

	// process for a compound transaction << needs to take care of time
	public boolean process() {
		for(Transaction temp: elements){
			if(temp == null) return false;
			
			try{
				temp.process();
			}catch(IllegalArgumentException e){
				System.out.println("CompoundTransaction status: false");
				throw new IllegalArgumentException("ERROR IN TRANSACTION");
			}

		}
		System.out.println("CompoundTransaction successful");
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

}
