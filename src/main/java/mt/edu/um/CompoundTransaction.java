package mt.edu.um;

import java.util.ArrayList;

public class CompoundTransaction{
	// using composite design pattern - tree of transactions
	
	private String name;   // name of compound transaction
	
	private ArrayList<Transaction> childTrans;  //leaves
	private ArrayList<CompoundTransaction> childTrans2;  // for sub transactions (otherwise use interfaces...)
	
	
	public CompoundTransaction(){
		
	}
	
	public CompoundTransaction(String n){
		setName(n);
		this.childTrans =  new ArrayList<Transaction>();
		this.childTrans2 = new ArrayList<CompoundTransaction>();
	}
	
	public void addTrans(Transaction t){
		childTrans.add(t);
	}
	
	public void addTrans2(CompoundTransaction ct){
		childTrans2.add(ct);
	}
	
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}

}
