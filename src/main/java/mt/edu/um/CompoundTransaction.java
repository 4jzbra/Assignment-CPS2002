package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction extends Transaction{
	// using composite design pattern
	
	private String name;   // name of compound transaction
	
	private ArrayList<Transaction> elements = new ArrayList<Transaction>();
	
	public CompoundTransaction(){
		
	}
	
	public CompoundTransaction(String n){ 
		setName(n);
	}
	
	// adding atomic and/or compound transactions to the ArrayList
	public boolean addTransaction(Transaction transaction){
		if(elements.contains(transaction)) return false;
		else return elements.add(transaction);
	}

	// process for a compound transaction << needs to take care of time
	public boolean process() {
		Transaction transaction = null;
		
		for(Transaction temp: elements){
			transaction = temp;
			System.out.println("Compound s "+temp.getSourceAccountNumber());
			System.out.println("Compound d "+temp.getDestinationAccountNumber());
			try{
				transaction.process();
			}catch(IllegalArgumentException e){
				System.out.println("CompoundTransaction status: false");
				throw new IllegalArgumentException("ERROR IN TRANSACTION");
			}
			
			// need to take care of the 15 seconds in CompoundTransaction
			try {
			    Thread.sleep(16000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
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
