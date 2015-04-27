package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction {
	// using composite design pattern - tree of transactions
	
	private String name;   // name of compound transaction
	
	private ArrayList<Transaction> childTrans =  new ArrayList<Transaction>();///
	
	
	public CompoundTransaction(){
		
	}
	
	public CompoundTransaction(String n){
		setName(n);
	}
	
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}

}
